package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.model.LoginModel;
import com.example.demo.repository.RegisterRepository;

@Service
public class RegisterServiceImplementation implements RegisterService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RegisterRepository registerRepo;
	
	@Override
	public Users registerUser(Users users) {
		Users user = new Users();
		
		user.setEmail(users.getEmail());
		user.setGender(users.getGender());
		user.setName(users.getName());
		user.setPassword(passwordEncoder.encode(users.getPassword()));
		user.setNumber(users.getNumber());
		System.out.println("users " + user);
		return registerRepo.save(user);
	}

	@Override
	public Users LoginUser(Users user) {
		// TODO Auto-generated method stub
		Users login = registerRepo.findByEmail(user.getEmail());
		if(login == null ) return null;
//		System.out.println();
//		System.out.println(login + "  " + login.getPassword());
		if(passwordEncoder.matches(user.getPassword(), login.getPassword())) return login;
		return null;
	}

}
