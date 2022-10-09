package com.digitalbooks.demo.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.demo.dto.BookDto;
import com.digitalbooks.demo.dto.ReaderBooks;
import com.digitalbooks.demo.dto.ReaderDto;
import com.digitalbooks.demo.entity.Book;
import com.digitalbooks.demo.entity.Reader;
import com.digitalbooks.demo.repository.BookRepository;
import com.digitalbooks.demo.repository.ReaderRepository;
import com.digitalbooks.demo.service.ReaderService;

@Service
public class ReaderServiceImpl implements ReaderService {
	@Autowired
	BookRepository BookRepository;

	@Autowired
	ReaderRepository readerRepository;

	@Override
	public String BuyBook(ReaderDto ReaderDto) {
		Reader reader = new Reader();
		reader.setReaderMailId(ReaderDto.getReaderMailId());
		reader.setReaderName(ReaderDto.getReaderName());
		int bookId = ReaderDto.getBookId();
		List<Book> bookList = BookRepository.findAllByBookId(bookId);
		if (bookList.isEmpty()) {
			reader.setBook(bookList);
		}
		reader.setPaymentId(ReaderDto.getPaymentId());

		Reader savedReader = readerRepository.save(reader);
		Optional<Book> readerOptional = BookRepository.findByBookId(bookId);
		Book Book = readerOptional.get();
		Book.setReader(savedReader);
		BookRepository.save(Book);
		return "book purchased successfull";
	}

	@Override
	public ReaderBooks getReaderBooks(String emailId, int paymentId) {
		ReaderBooks ReaderBooks = new ReaderBooks();
		Optional<Reader> readerOptional = readerRepository.findByReaderMailIdAndPaymentId(emailId, paymentId);
		if (readerOptional.isPresent()) {
			Reader reader = readerOptional.get();
			ReaderBooks.setReaderName(reader.getReaderName());

			List<BookDto> booksList = formBookDetails(reader.getBook());
			ReaderBooks.setBooksList(booksList);
		}
		return ReaderBooks;
	}

	private List<BookDto> formBookDetails(List<Book> books) {
		List<BookDto> bookDtoList = new ArrayList<>();
		for (Book book : books) {
			BookDto bookDto = new BookDto();

			bookDto.setTittle(book.getTittle());
			bookDto.setCategory(book.getCategory());
			bookDto.setPublisher(book.getAurthor().getFirstName());
			bookDtoList.add(bookDto);
		}
		return bookDtoList;

	}

	@Override
	public BookDto readBook(String email, int bookId) {
		Optional<Book> readerOptional = BookRepository.findByBookId(bookId);
		BookDto bookDto = new BookDto();
		if (readerOptional.isPresent()) {
			Book book = readerOptional.get();
			bookDto.setTittle(book.getTittle());
			bookDto.setCategory(book.getCategory());
			bookDto.setPublisher(book.getAurthor().getFirstName());
		}
		return bookDto;
	}

	@Override
	public ReaderBooks getReaderBooks(String emailId) {
		ReaderBooks ReaderBooks = new ReaderBooks();
		Optional<Reader> readerOptional = readerRepository.findByReaderMailIdAndPaymentIdIsNotNull(emailId);
		if (readerOptional.isPresent()) {
			Reader reader = readerOptional.get();
			ReaderBooks.setReaderName(reader.getReaderName());

			List<BookDto> booksList = formBookDetails(reader.getBook());
			ReaderBooks.setBooksList(booksList);
		}
		return ReaderBooks;
	}

}
