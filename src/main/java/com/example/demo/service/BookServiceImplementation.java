package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Books;
import com.example.demo.repository.BookRepository;

@Service
public class BookServiceImplementation implements BookService {

	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public Books postBook(Books books) {
		System.out.println(books);
		return bookRepo.save(books);
	}

	@Override
	public List<Books> getBookByTitle(String title) {
		System.out.println(title);
		return bookRepo.findByTitleIgnoreCase(title);
	}

	@Override
	public Books getBookById(int id) {
		System.out.println(bookRepo.findById(id).get());
		return bookRepo.findById(id).get();
	}

	@Override
	public Books putBook(int id, Books book) {
		Books books = bookRepo.findById(id).get();
		if(Objects.nonNull(book.getAuthor()) && !"".equalsIgnoreCase(book.getAuthor()))
			books.setAuthor(book.getAuthor());
		if(Objects.nonNull(book.getImage_link()) && !"".equalsIgnoreCase(book.getImage_link()))
			books.setImage_link(book.getImage_link());
		if(Objects.nonNull(book.getTitle()) && !"".equalsIgnoreCase(book.getTitle()))
			books.setTitle(book.getTitle());
		if(Objects.nonNull(book.getPages()))
			books.setPages(book.getPages());
		if(Objects.nonNull(book.getLanguage()) && !"".equalsIgnoreCase(book.getLanguage()))
			books.setLanguage(book.getLanguage());
		if(Objects.nonNull(book.getLink()) && !"".equalsIgnoreCase(book.getLink()))
			books.setLink(book.getLink());
		if(Objects.nonNull(book.getYear()))
			books.setYear(book.getYear());
		return bookRepo.save(books);
	}

	@Override
	public List<Books> getFavorites() {
		return bookRepo.findByFavorites();
	}

	@Override
	public Books putFavorites(int id) {
		Books books = bookRepo.findById(id).get();
		if(!books.isFavorites())
			books.setFavorites(true);
		bookRepo.save(books);
		return books;
	}

}
