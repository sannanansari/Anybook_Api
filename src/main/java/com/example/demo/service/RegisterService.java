package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.model.LoginModel;

@Service
public interface RegisterService {

	public Users registerUser(Users users);

	public Users LoginUser(Users loginModel);

}
