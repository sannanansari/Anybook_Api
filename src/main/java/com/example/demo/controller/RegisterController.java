package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.service.RegisterService;

@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@PostMapping(value= "/register")
	public Users registerUser(@RequestBody Users users) {
		System.out.println(users);
		return registerService.registerUser(users);
	}
}
