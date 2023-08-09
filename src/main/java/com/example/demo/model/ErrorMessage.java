package com.example.demo.model;

import javax.persistence.Entity;

import org.springframework.http.HttpStatus;


public class ErrorMessage {
   
	
	private HttpStatus status;
	private String name;
	
	public ErrorMessage(HttpStatus status, String name) {
		super();
		this.status = status;
		this.name = name;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ErrorMessage [status=" + status + ", name=" + name + "]";
	}
	
	
}
