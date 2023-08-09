package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Builder;

@Entity
//@Builder
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "books_generator")
	private int id;
	@NotNull(message = "Author Name cnnot be empty.")
	private String author;
	private String country;
	@NotNull(message = "Image link connot be null")
	private String image_link;
	private String link;
	private int pages;
	private String title;
	private int year;
	private String language = "English";
	private boolean favorites;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
//	public String getImageLink() {
//		return image_link;
//	}
//	
//	public void setImageLink(String image_link) {
//		image_link = image_link;
//	}
	
	public String getLink() {
		return link;
	}
	
	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public int getPages() {
		return pages;
	}
	
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "book [id=" + id + ", author=" + author + ", country=" + country + ", ImageLink=" + image_link + ", link="
				+ link + ", pages=" + pages + ", title=" + title + ", year=" + year + "]";
	}
	
	public Books() {
		super();
	}
	
	public boolean isFavorites() {
		return favorites;
	}
	
	public void setFavorites(boolean favorites) {
		this.favorites = favorites;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = "English";
	}

	
	
}
