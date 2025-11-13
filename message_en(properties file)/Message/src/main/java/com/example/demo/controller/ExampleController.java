package com.example.demo.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
	
	@Autowired
	private MessageSource  messageSource ;

	private Locale locale = LocaleContextHolder.getLocale();
	
	@GetMapping("check")
	public ResponseEntity<?> healthCheck() {
		return new ResponseEntity<>(messageSource.getMessage("welcome.back", null, locale),HttpStatus.OK);
	}
}
