package com.fps.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fps.helper.AuthHelper;
import com.fps.model.CommonResponse;
import com.fps.model.LoginRequest;
import com.fps.service.AuthService;

@RestController
@RequestMapping("/auth-serivce")
public class AuthController {
	
	Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private AuthService service;

	@PostMapping("/api/v1/login")
	public ResponseEntity<CommonResponse> doLogin(@RequestBody LoginRequest request) {
		logger.debug("Request received for login: {}", request);
		boolean isValidUser = service.isValidUser(request.getCustomerId());
		final CommonResponse response = AuthHelper.formatCommonResponse(isValidUser);
		
		return new ResponseEntity<CommonResponse>(response, AuthHelper.getStatusCode(response.getStatus()));
	}

}
