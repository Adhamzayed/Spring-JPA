package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Auther;
import com.example.demo.Repositoty.AutherRep;

@Service
public class AutherService {

	@Autowired
	private AutherRep rep;

	public long count() {
		return rep.count();
	}

	public Iterable<Auther> findAll() {
		return rep.findAll();
	}

	public Auther findById(Long id) {
		return rep.findById(id).get();
	}

	public Auther insert(Auther auther) {
		return rep.save(auther);
	}

	public Auther update(Auther auther) {
		Auther current = rep.findById(auther.getId()).get();
		current.setName(auther.getName());
		return rep.save(current);
	}

	public void deleteById(Long id) {
		rep.deleteById(id);
	}

	public void deleteAll() {
		rep.deleteAll();
	}
	
	
	public List<Auther>  insertAll(List<Auther> auther) {
		return (List<Auther>) rep.saveAll(auther);
	}
	
}
