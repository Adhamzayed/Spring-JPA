package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.Auther;
import com.example.demo.Service.AutherService;

@RestController
@RequestMapping("/auther")
public class AutherController {

	@Autowired
	private AutherService ser;

	@GetMapping("/count")
	public long count() {
		return ser.count();
	}

	@GetMapping("")
	public Iterable<Auther> findAll() {
		return ser.findAll();
	}

	@GetMapping("/byid/{id}")
	public Auther findById(@PathVariable Long id) {
		return ser.findById(id);
	}

	@PostMapping("")
	public Auther insert(@RequestBody Auther auther) {
		return ser.insert(auther);
	}

	@PutMapping("")
	public Auther update(@RequestBody Auther auther) {
		return ser.update(auther);
	}

	@DeleteMapping("/byid/{id}")
	public void deleteById(@PathVariable Long id) {
		ser.deleteById(id);
	}

	@DeleteMapping("")
	public void deleteAll() {
		ser.deleteAll();
	}
}
