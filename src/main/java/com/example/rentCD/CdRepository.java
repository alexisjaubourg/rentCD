package com.example.rentCD;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CdRepository extends CrudRepository<Cd, Long> {
	
	List<Cd> findByName(String name);

}