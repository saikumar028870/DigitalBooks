package com.digitalbooks.demo.service;

import org.springframework.web.bind.annotation.RequestParam;

import com.digitalbooks.demo.dto.BookDto;
import com.digitalbooks.demo.dto.ReaderBooks;
import com.digitalbooks.demo.dto.ReaderDto;

public interface ReaderService {
	
	String BuyBook(ReaderDto ReaderDto);
	
	ReaderBooks getReaderBooks( String emailId ,  int paymentId);
	
	BookDto readBook(String email , int bookId);
	
	ReaderBooks getReaderBooks( String emailId );


}
