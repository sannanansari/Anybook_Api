package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Books;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

@RestController 
public class BookController {
	
	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private BookService bookService;
	
	@GetMapping(value="/getBooks")
	@CrossOrigin(origins = "*")
	public List<Books> getBook() {
		return bookRepo.findAll();
	}
	
	@GetMapping(value="/getBook/{id}")
	@CrossOrigin(origins= "*")
	public Books getBookbyId(@PathVariable("id") int id) {
		return bookService.getBookById(id); 
	}
	
	@GetMapping(value="/getBookByTitle/{title}")
	@CrossOrigin(origins = "*")
	public List<Books> getBookByTitle(@PathVariable("title") String title) {
		return bookService.getBookByTitle(title);
	}
	
	@GetMapping(value="/getFavorites")
	@CrossOrigin(origins="*")
	public List<Books> getFavorites() {
		return bookService.getFavorites();
	}
	
	@PostMapping(value="/postBook")
	@CrossOrigin(origins = "*")
	public Books postBook(@RequestBody Books books) {
		return bookService.postBook(books);
	}
	
	@PutMapping(value="/putBook/{id}")
	@CrossOrigin(origins="*")
	public Books putBook(@PathVariable("id") int id, @RequestBody Books book) {
		return bookService.putBook(id,book);
	}
	
	@PutMapping(value="/putFavorites/{id}")
	@CrossOrigin(origins="*")
	public Books putFavorites(@PathVariable int id) {
		return bookService.putFavorites(id);
	}
	
}
