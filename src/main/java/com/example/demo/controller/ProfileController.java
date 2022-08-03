package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Profile;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.service.ProfileService;

@RestController
public class ProfileController {

	@Autowired
	private ProfileRepository profileRepo;
	
	@Autowired
	private ProfileService  profileService;
	
	@GetMapping(value="/profile")
	public List<Profile> getProfile() {
		return profileRepo.findAll();
	}
	
	@GetMapping(value="/profile/{id}")
	@CrossOrigin(origins = "*")
	public Optional<?> getProfileById(@PathVariable("id") int id) {
		return profileService.getProfileById(id);
	}
	
	@PutMapping(value="/profile/{id}")
	@CrossOrigin(origins="*")
	public Profile putProfileById(@PathVariable("id") int id,@RequestBody Profile profile) {
		return profileService.putProfileById(id,profile);
	}
	
	@PostMapping(value="/profile")
	public Profile postProfile(@RequestBody Profile profile) {
		System.out.println(profile);
		return profileService.postProfile(profile);
	}
	
}
