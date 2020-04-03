package com.enosh.books.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enosh.books.entities.Author;
import com.enosh.books.repository.AuthorRepository;

@Component
public class AuthorDbdao {

	private AuthorRepository repository;

	@Autowired
	public AuthorDbdao(AuthorRepository repository) {
		this.repository = repository;
	}
	
	public Author save(Author author) throws Exception {
		try {
			return repository.save(author);
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Optional<Author> findById(Long id) {
		return repository.findById(id);
	}
	
	public void updateFirstName(String firstName, Long id) throws Exception {
		if(!repository.existsById(id)) {
			throw new Exception("No Author by the id " + id);
		}
		repository.updateFirstName(firstName, id);
	}
}
