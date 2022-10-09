package com.digitalbooks.demo.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class BookDto {

	private String tittle;

	private String category;

	private String price;

	private String publisher;

	private boolean active;

	public int getAurthorId() {
		return aurthorId;
	}

	public void setAurthorId(int aurthorId) {
		this.aurthorId = aurthorId;
	}

	private String content;

	private int aurthorId;

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
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
