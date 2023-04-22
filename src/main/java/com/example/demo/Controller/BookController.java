package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.BookDTO;
import com.example.demo.Service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService ser;

	@GetMapping("/count")
	public Long count() {
		return ser.count();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Book  book =ser.findById(id);
		BookDTO dto=new BookDTO();
		dto.setId(book.getId());
		dto.setName(book.getName());
		dto.setPrice(book.getPrice());
		dto.setAuther(book.getAuther());
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("")
	public List<Book> findAll(){
		return (List<Book>) ser.findAll();
	}
	
	@PostMapping("")
	public Book insert(@RequestBody Book book) {
		return ser.insert(book);
	}
	
	@PutMapping("")
	public Book update(@RequestBody Book book) {
		return ser.insert(book);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		ser.deleteById(id);
	}
	
	@DeleteMapping("")
	public void deleteAll() {
		ser.deleteAll();
	}
	
}
