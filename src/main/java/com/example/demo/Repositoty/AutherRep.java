package com.example.demo.Repositoty;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Auther;
@Repository
public interface AutherRep extends CrudRepository<Auther,Long>{

}
