package com.digitalbooks.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalbooks.demo.entity.Aurthor;

public interface AurthorRepository extends JpaRepository<Aurthor, Integer> {
	
	Optional<Aurthor> findByEmail(String email);

}
