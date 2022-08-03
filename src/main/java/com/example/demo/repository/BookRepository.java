package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Books;

public interface BookRepository extends JpaRepository<Books, Integer> {
	
	@Query(value="SELECT b FROM Books b WHERE UPPER(b.title) LIKE CONCAT('%',UPPER(:title),'%')")
	 List<Books> findByTitleIgnoreCase( @Param("title") String title);
	 

	 List<Books> findByAuthor(String author);

	@Query(value="SELECT b FROM Books b WHERE b.favorites=true")
	List<Books> findByFavorites();
}
