package com.rest.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<Login> loginMethod(@Valid @RequestBody Login login) throws LoginException, Exception {
		if (!loginService.getUserByUsername(login.getUsername())) {
			return new ResponseEntity<>(loginService.addNewLogin(login), HttpStatus.ACCEPTED);
		} else
			throw new LoginException("Error Occured while adding new user due to existance of same username!");
	}

	@GetMapping("/getRegisteredUsers")
	public List<Login> getAllUsers() throws LoginException {
		List<Login> list = new ArrayList<Login>();
		list = loginService.getAllUsers();
		if (!list.isEmpty()) {
			return list;
		} else
			throw new LoginException("No registered users available in database!");
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable("userId") int userId) throws LoginException {
		if(loginService.exists(userId)) {
			loginService.delete(userId);
		}
		else {
			throw new LoginException("Record can't be deleted! Record doesn't exist!");
		}
	}
	
	@PutMapping("/updateUserDetails")
	public Login updateUser(@Valid @RequestBody Login login) {
		return loginService.update(login);
	}
}
