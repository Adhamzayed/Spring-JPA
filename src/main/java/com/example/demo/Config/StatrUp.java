package com.example.demo.Config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.Auther;
import com.example.demo.Entity.Book;
import com.example.demo.Service.AutherService;
import com.example.demo.Service.BookService;

@Component
public class StatrUp implements CommandLineRunner {

	@Autowired
	private BookService bookser;

	@Autowired
	private AutherService autherser;

	@Override
	public void run(String... args) throws Exception {

		if (bookser.count() == 0 || autherser.count() == 0) {
			// Add Some Data for A Table
			Auther a = new Auther();
			a.setName(" DR: Ahmed Tawfiq");

			Auther a1 = new Auther();
			a1.setName("DR : Mustafa Mahmoud");

			autherser.insertAll(Arrays.asList(a, a1));

			// Adding Some Data For Books Table
			Book b = new Book();
			b.setName("Paranormal");
			b.setAuther(a);
			b.setPrice(50);
			Book b1 = new Book();
			b1.setName("In The Rat Lane");
			b1.setAuther(a);
			b1.setPrice(70);
			Book b2 = new Book();
			b2.setName("Utopia");
			b2.setAuther(a);
			b2.setPrice(100);

			Book b3 = new Book();
			b3.setName("Spider");
			b3.setAuther(a1);
			b3.setPrice(120);
			Book b4 = new Book();
			b4.setName("R7lte Mn Ekshak Ela Elyaken");
			b4.setAuther(a1);
			b4.setPrice(150);
			Book b5 = new Book();
			b5.setName("Alro7 W Elgasad");
			b5.setAuther(a1);
			b5.setPrice(180);
			bookser.insertAll(Arrays.asList(b, b1, b2, b3, b4, b5));
		}

	}

}
