package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Users;
import com.example.demo.model.LoginModel;

public interface RegisterRepository extends JpaRepository<Users, Integer> {

	Users findByEmail(String email);

}
