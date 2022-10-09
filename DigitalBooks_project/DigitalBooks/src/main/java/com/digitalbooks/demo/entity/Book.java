package com.digitalbooks.demo.entity;

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
@Table(name ="BOOK")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BOOK_ID")
	private int bookId;
	
	@Column(name = "BOOK_TITTLE")
	private String tittle;
	
	@Column(name = "BOOK_CATEGORY")
	private String category;
	
	@Column(name = "BOOK_PRICE")
	private String price;
	
	@Column(name = "BOOK_PUBLISHER")
	private String publisher;
	
	@Column(name = "ACTIVE")
	private boolean isActive;
	
	@Column(name = "BOOK_CONTENT")
	private String content;
	
	
//	@Column (name = "AURTHOR_ID")
//	private int aurthorId;
	

	public Aurthor getAurthor() {
		return aurthor;
	}

	public void setAurthor(Aurthor aurthor) {
		this.aurthor = aurthor;
	}

	
	@ManyToOne
	@JoinColumn(name = "AURTHOR_ID")
	private Aurthor aurthor;
	
	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}


	@ManyToOne
	@JoinColumn(name="READER_ID")
	private Reader reader;


	public int getBookid() {
		return bookId;
	}

//	public int getAurthorId() {
//		return aurthorId;
//	}
//
//	public void setAurthorId(int aurthorId) {
//		this.aurthorId = aurthorId;
//	}

	public void setBookid(int bookid) {
		this.bookId = bookid;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
