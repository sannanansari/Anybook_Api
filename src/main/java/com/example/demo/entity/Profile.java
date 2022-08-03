package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_generator")
	private int id;
	private String name;
	private Long number;
	private String email;
	private String gender;
//	@Column(columnDefinition="false")
	private Boolean isAdmin = false; 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public Profile() {
//		super();
//		this.id = id;
//		this.name = name;
//		this.number = number;
//		this.email = email;
//		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", number=" + number + ", email=" + email + ", gender=" + gender
				+ "]";
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = false;
	}

}
