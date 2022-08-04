package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.model.LoginModel;
import com.example.demo.service.RegisterService;

@RestController
public class LoginController {

	@Autowired
	private RegisterService registerService;
	
	@PostMapping(value="/login")
	public String LoginUser(@RequestBody Users loginModel) {
		
		Users s = registerService.LoginUser(loginModel);
		return s.getRole();
		
	}
	
}
