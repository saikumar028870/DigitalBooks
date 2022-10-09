package com.digitalbooks.demo.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.digitalbooks.demo.dto.BookDto;
import com.digitalbooks.demo.entity.Aurthor;
import com.digitalbooks.demo.entity.Book;
import com.digitalbooks.demo.service.BookSearchFetchResult;
import com.digitalbooks.demo.service.BookService;
import com.digitalbooks.demo.repository.BookRepository;
import com.digitalbooks.demo.repository.AurthorRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository BookRepository;

	@Autowired
	AurthorRepository AurthorRepository;

	@Override
	public String saveBookDetails(BookDto bookDetails) {
		Book book = new Book();
		book.setTittle(bookDetails.getTittle());
		book.setCategory(bookDetails.getCategory());
		book.setContent(bookDetails.getContent());
		book.setPrice(bookDetails.getPrice());
		book.setPublisher(bookDetails.getPublisher());
		book.setActive(bookDetails.isActive());
		Optional<Aurthor> Aurthor = AurthorRepository.findById(bookDetails.getAurthorId());
		book.setAurthor(Aurthor.get());
		BookRepository.save(book);
		return "book has been added";
	}

	@Override
	public BookDto getBookByBookId(String bookId) {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public String updateBook(BookDto bookDetails) {
		String response = "";
		Optional<Book> bookOptional = BookRepository.findByTittle(bookDetails.getTittle());

		if (bookOptional.isPresent()) {
			System.out.println("====");
			if (!bookDetails.isActive()) {
				Book book = bookOptional.get();
				book.setActive(false);
				BookRepository.save(book);
				response = "book has been blocked";
			} else {
				Book book = bookOptional.get();
				book.setTittle(bookDetails.getTittle());
				book.setCategory(bookDetails.getCategory());
				book.setContent(bookDetails.getContent());
				book.setPrice(bookDetails.getPrice());
				book.setPublisher(bookDetails.getPublisher());
				book.setActive(bookDetails.isActive());
				Optional<Aurthor> Aurthor = AurthorRepository.findById(bookDetails.getAurthorId());
				book.setAurthor(Aurthor.get());
				BookRepository.save(book);
				response = "book updated successfully";
			}
		} else {
			response = "book update failed";
		}
		return response;
	}

	@Override
	public BookDto searchBooks(String category, String author, String price, String publisher) {
		BookSearchFetchResult BookSearchFetchResult = BookRepository.SerchByAll(category, author, price, publisher);
		BookDto BookDto = new BookDto();
		BookDto.setTittle(BookSearchFetchResult.getTittle());
		BookDto.setPublisher(publisher);
		return BookDto;
	}

}
