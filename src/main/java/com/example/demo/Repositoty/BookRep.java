package com.example.demo.Repositoty;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Book;
@Repository
public interface BookRep extends JpaRepository<Book,Long>{
	
	@Override
	@EntityGraph(attributePaths = "auther")
	Optional<Book> findById(Long id) ;

	@Override
	@EntityGraph(attributePaths = "auther")
	 List<Book> findAll() ;
}
