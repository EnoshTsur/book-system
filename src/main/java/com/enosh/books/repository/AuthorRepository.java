package com.enosh.books.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enosh.books.entities.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{

	@Transactional
	@Modifying
	@Query("UPDATE Author a set a.firstName = :firstName WHERE a.id = :id")
	void updateFirstName(@Param("firstName") String firstName, @Param("id") Long id);
}
