package com.enosh.books;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.enosh.books.dao.AuthorDbdao;
import com.enosh.books.entities.Author;

@SpringBootTest
class AuthorTests {
	
	@Autowired
	private AuthorDbdao dao;

	@Test
	void contextLoads() {
	}
	
	@Test
	void save() {
//		
//		Author author = new Author(3L, "Efratos", "Avner");
//		try {
//			
//			Author afterSave = dao.save(author);
//			System.out.println(afterSave);
//			
//		} catch (Exception e) {
//			
//			System.out.println(e.getMessage());
//		}
//		
	}
	
	@Test
	void update() {
//		dao.updateFirstName("Effy", 3L);
	}

}
