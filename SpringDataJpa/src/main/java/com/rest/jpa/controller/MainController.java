package com.rest.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.jpa.exception.LoginException;
import com.rest.jpa.model.Login;
import com.rest.jpa.service.LoginService;

@RestController
public class MainController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<Login> loginMethod(@RequestBody Login login) throws LoginException, Exception {
		if (!login.getUsername().isEmpty() && !login.getPassword().isEmpty()
				&& !loginService.getUserByUsername(login.getUsername())) {
			return new ResponseEntity<>(loginService.addNewLogin(login), HttpStatus.ACCEPTED);
		} else
			throw new LoginException("Error Occured while adding new user");
	}

	@GetMapping("/getRegisteredUsers")
	public List<Login> getAllUsers() throws LoginException {
		List<Login> list = new ArrayList<Login>();
		list.addAll(loginService.getAllUsers());

		if (!list.isEmpty()) {
			return list;
		} else
			throw new LoginException("No registered users available in database!");
	}

}
