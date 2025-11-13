package com.example.demo.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import com.example.demo.entity.ApiLogs;
import com.example.demo.repository.ApilogsRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TrailFilter extends OncePerRequestFilter {

	@Autowired
	private ApilogsRepository apilogsRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);

		String endpoint = request.getRequestURI();
		String method = request.getMethod();

		//  Skip login/signup
		if (endpoint.contains("/login") || endpoint.contains("/signUp")) {
			filterChain.doFilter(wrappedRequest, response);
			return;
		}

		try {
			filterChain.doFilter(wrappedRequest, response);

			String email = "Anonymous";
			if (SecurityContextHolder.getContext().getAuthentication() != null) {
				email = SecurityContextHolder.getContext().getAuthentication().getName();
				if(email.equals("Anonymous")) {
					email = "Failed attempt" ;
				}
			}

			//  Read body safely (after request is processed)
			String payload = "";
			if ("POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method)) {
				byte[] buf = wrappedRequest.getContentAsByteArray();
				if (buf.length > 0) {
					payload = new String(buf, 0, buf.length, StandardCharsets.UTF_8);
				}
			}

			//  Save API trail log
			String clientIp = getClientIp(request);
			ApiLogs logs = new ApiLogs();
			logs.setEndPoint(endpoint);
			logs.setEmail(email);
			logs.setPayload(payload);
			logs.setIp(clientIp);
			logs.setTimestamp(new Date());
			apilogsRepository.save(logs);

		} catch (Exception e) {
			e.printStackTrace();
			handleException(response, HttpStatus.INTERNAL_SERVER_ERROR, "Trail logging failed");
		}
	}

	private void handleException(HttpServletResponse response, HttpStatus status, String message) throws IOException {
		try {
			response.setStatus(status.value());
			response.setContentType("application/json");
			String jsonResponse = String.format("{\"status\": %d, \"message\": \"%s\", \"data\": null}", status.value(),
					message);
			response.getWriter().write(jsonResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private String getClientIp(HttpServletRequest request) {
	    String ip = request.getHeader("X-Forwarded-For");
	    if (ip != null && !ip.isEmpty() && !"unknown".equalsIgnoreCase(ip)) {
	        return ip.split(",")[0];
	    }
	    return request.getRemoteAddr();
	}
}
