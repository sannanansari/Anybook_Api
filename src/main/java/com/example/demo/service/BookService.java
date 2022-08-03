package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Books;

@Service
public interface BookService {

	public Books postBook(Books books);

	public List<Books> getBookByTitle(String title);

	public Books getBookById(int id);

	public Books putBook(int id, Books book);

	public List<Books> getFavorites();

	public Books putFavorites(int id);

}
