package com.fps.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fps.helper.AuthHelper;
import com.fps.model.CommonResponse;
import com.fps.model.LoginRequest;
import com.fps.service.AuthService;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {
	@Mock
	private AuthService service;
	@InjectMocks
	private AuthController controller;

	@Test
	public void testLoginSuccess() {
		when(service.isValidUser(1)).thenReturn(true);
		ResponseEntity<CommonResponse> respose = controller.doLogin(getRequest());
		assertEquals(respose, getResponse(true));

	}

	@Test
	public void testLoginFailure() {
		when(service.isValidUser(1)).thenReturn(false);
		ResponseEntity<CommonResponse> respose = controller.doLogin(getRequest());
		assertEquals(respose, getResponse(false));

	}

	private LoginRequest getRequest() {
		LoginRequest request = new LoginRequest();
		request.setCustomerId(1);
		return request;

	}

	private ResponseEntity<CommonResponse> getResponse(boolean status) {
		CommonResponse formatCommonResponse = AuthHelper.formatCommonResponse(status);
		return new ResponseEntity<>(formatCommonResponse, AuthHelper.getStatusCode(formatCommonResponse.getStatus()));

	}
}
