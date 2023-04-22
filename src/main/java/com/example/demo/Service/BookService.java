package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Book;
import com.example.demo.Repositoty.BookRep;

@Service
public class BookService {

	@Autowired
	private BookRep rep;

	public Long count() {
		return rep.count();
	}
	
	public Iterable<Book> findAll() {
		return rep.findAll();
	}

	public Book findById(Long id) {
		return rep.findById(id).get();
	}

	public Book insert(Book book) {
		return rep.save(book);
	}

	public Book update(Book book) {
		Book current = rep.findById(book.getId()).get();
		current.setName(book.getName());
		current.setPrice(book.getPrice());
		current.setAuther(book.getAuther());
		return rep.save(current);
	}

	public void deleteById(Long id) {
		rep.deleteById(id);
	}

	public void deleteAll() {
		rep.deleteAll();
	}
	
	public List<Book>  insertAll(List<Book> book) {
		return (List<Book>) rep.saveAll(book);
	}
	
}
