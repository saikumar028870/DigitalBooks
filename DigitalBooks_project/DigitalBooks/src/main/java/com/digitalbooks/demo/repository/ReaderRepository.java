package com.digitalbooks.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitalbooks.demo.entity.Book;
import com.digitalbooks.demo.entity.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {
	
	Optional<Reader> findByReaderMailIdAndPaymentId(String mailId , int PId);
	
	Optional<Reader> findByReaderMailId(String mailId);
	
	Optional<Reader> findByReaderMailIdAndPaymentIdIsNotNull(String mailId);

}
