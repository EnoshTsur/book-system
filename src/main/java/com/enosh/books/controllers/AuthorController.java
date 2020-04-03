package com.enosh.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enosh.books.dao.AuthorDbdao;
import com.enosh.books.entities.Author;

@RestController
@RequestMapping("/author")
@CrossOrigin(origins = "*")
public class AuthorController {
	
	private AuthorDbdao dao;

	@Autowired
	public AuthorController(AuthorDbdao dao) {
		this.dao = dao;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity create(@RequestBody Author author) {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.contentType(MediaType.APPLICATION_JSON)
					.body(dao.save(author));
			
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.contentType(MediaType.TEXT_PLAIN)
					.body(e.getMessage());
		}
	}
	
	// http://localhost:7070/author/updateFirstName?firstName=sdfsd&id=3
	@PutMapping("/updateFirstName")
	public ResponseEntity update(
			@RequestParam("firstName") String firstName, 
			@RequestParam("id") Long id
			) {
		try {
			
			dao.updateFirstName(firstName, id);
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.contentType(MediaType.TEXT_PLAIN)
					.body(firstName + " updated successfully");
			
		} catch (Exception e) {
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.contentType(MediaType.TEXT_PLAIN)
					.body(e.getMessage());
		}
	}
	

}
