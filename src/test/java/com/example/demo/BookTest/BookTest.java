package com.example.demo.BookTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Books;
import com.example.demo.service.BookService;

@SpringBootTest
class BookTest {

	@Autowired
	private BookService bookService;

	@BeforeEach
	void setUp() throws Exception {
//		Books book = Books.builder().a
	}
	
//	@Test
//	public void getTitleById_isWorking() {
//		Books book = bookService.getBookById(1);
//		
//		
//	}
	

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
