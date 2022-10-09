package com.digitalbooks.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitalbooks.demo.entity.Book;
import com.digitalbooks.demo.service.BookSearchFetchResult;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	Optional<Book> findByTittle(String tittle);

	Optional<Book> findByBookId(int bookId);

	List<Book> findAllByBookId(int bookId);
	
	@Query(value = "select B.BOOK_TITTLE AS tittle , A.first_name AS firstName from BOOK B join AURTHOR A ON B.AURTHOR_ID = A.AURTHOR_ID where B.BOOK_CATEGORY =:category"
			+ " AND A.AURTHOR_ID =:author   AND B.BOOK_PRICE =:price AND BOOK_PUBLISHER =:publisher ",nativeQuery = true)
	BookSearchFetchResult SerchByAll(String category , String author , String price , String publisher);
   
}
