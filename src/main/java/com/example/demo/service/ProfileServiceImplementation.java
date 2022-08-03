package com.example.demo.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Profile;
import com.example.demo.repository.ProfileRepository;

@Service
public class ProfileServiceImplementation implements ProfileService {

	@Autowired
	private ProfileRepository profileRepo;
	
	@Override
	public Profile postProfile(Profile profile) {
		System.out.println("Values " + profile);
		return profileRepo.save(profile);
	}

	@Override
	public Optional<Profile> getProfileById(int id) {
		return profileRepo.findById(id);
	}

	@Override
	public Profile putProfileById(int id,Profile profile) {
		Profile profiles = profileRepo.findById(id).get();
		if(Objects.nonNull(profile.getName()) && !"".equalsIgnoreCase(profile.getName()))
			profiles.setName(profiles.getName());
		if(Objects.nonNull(profile.getNumber()))
			profiles.setNumber(profile.getNumber());
		if(Objects.nonNull(profile.getEmail()) && !"".equalsIgnoreCase(profile.getEmail()))
			profiles.setEmail(profile.getEmail());
		if(Objects.nonNull(profile.getGender()) && !"".equalsIgnoreCase(profile.getGender()))
			profiles.setGender(profile.getGender());
		System.out.println(profiles);
		return profileRepo.save(profiles);
	}

}
