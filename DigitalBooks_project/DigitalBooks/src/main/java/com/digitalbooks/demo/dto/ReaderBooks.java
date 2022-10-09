package com.digitalbooks.demo.dto;

import java.util.List;

public class ReaderBooks {
	
	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public List<BookDto> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<BookDto> booksList) {
		this.booksList = booksList;
	}

	private String readerName;
	
	private List<BookDto> booksList;
}
