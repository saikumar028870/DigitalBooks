package com.digitalbooks.demo.service;

import com.digitalbooks.demo.dto.BookDto;

public interface BookService {
	
	String saveBookDetails(BookDto bookDetails);
	
	BookDto getBookByBookId(String bookId);
	
	String updateBook(BookDto bookDetails);
	
	BookDto searchBooks(String category , String author , String price , String publisher);

}
