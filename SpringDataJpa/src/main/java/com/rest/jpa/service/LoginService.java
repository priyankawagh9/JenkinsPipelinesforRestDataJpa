package com.rest.jpa.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.jpa.model.Login;
import com.rest.jpa.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	public Login addNewLogin(Login login)
	{
		return loginRepository.save(login);
	}
	
	public List<Login> getAllUsers()
	{
		return loginRepository.findAll();
		
	}

	public boolean getUserByUsername(String username) 
	{
		List<Login> list = loginRepository.findByUsername(username);
		if(list.size()>0)
		{
			return true;
		}
		return false;
	}

	public Optional<Login> findUserById(int userId) {
		return loginRepository.findById(userId);
	}

	public void delete(int userId) {
		loginRepository.deleteById(userId);
	}

	public Login update(Login login) {
		
		return loginRepository.save(login);
	}

	public boolean exists(int userId) {
		return loginRepository.existsById(userId);
		
	}
}
