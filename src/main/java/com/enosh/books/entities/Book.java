package com.enosh.books.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "title", nullable = false, unique = true, length = 30)
	private String title;
	
	@Column(name = "publish_date", nullable = false)
	private LocalDate publishDate;
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;
	
	@ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
	private List<Customer> customers;
	
	public Book() {}

	public Book(Long id, String title, LocalDate publishDate, double price, Author author, List<Customer> customers) {
		this.id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.price = price;
		this.author = author;
		this.customers = customers;
	}

	public Book(String title, LocalDate publishDate, double price, Author author, List<Customer> customers) {
		this.title = title;
		this.publishDate = publishDate;
		this.price = price;
		this.author = author;
		this.customers = customers;
	}

	public Book(String title, LocalDate publishDate, double price, Author author) {
		this.title = title;
		this.publishDate = publishDate;
		this.price = price;
		this.author = author;
	}

	public Book(String title, LocalDate publishDate, double price) {
		this.title = title;
		this.publishDate = publishDate;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publishDate=" + publishDate + ", price=" + price + "]";
	}
	
	
	
}
