package com.rest.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.jpa.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	List<Login> findByUsername(String username);
}
