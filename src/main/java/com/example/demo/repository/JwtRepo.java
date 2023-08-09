package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserJwt;

public interface JwtRepo extends JpaRepository<UserJwt, Long> {

	Optional<UserJwt> findByEmail(String email);

}
