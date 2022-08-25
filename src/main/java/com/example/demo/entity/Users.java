package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String name;
	private String email;
	private long number;
	private String gender;
	private String password;
	
	private String role = "user";
//	private String ConfirmPassword;
	
	public Users(int id, String name, String email, long number, String gender, String password, String role) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.number = number;
		this.gender = gender;
		this.password = password;
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = "user";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public String getConfirmPassword() {
//		return ConfirmPassword;
//	}
//	public void setConfirmPassword(String confirmPassword) {
//		ConfirmPassword = confirmPassword;
//	}
	
	
	@Override
	public String toString() {
		return "Users [Id=" + Id + ", name=" + name + ", email=" + email + ", number=" + number + ", gender=" + gender
				+ ", Password=" + this.password + ", role=" + role + "]";
	}
	

	public Users() {
		super();
	}
	
	
	
	
	
	
}
