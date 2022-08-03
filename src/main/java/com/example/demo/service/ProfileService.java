package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Profile;

@Service
public interface ProfileService {

	public Profile postProfile(Profile profile);

	public Optional<Profile> getProfileById(int id);

	public Profile putProfileById(int id,Profile profile);

}
