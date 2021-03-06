package com.example.rentCD;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
	
	List<Artist> findByArtistName(String name);
	
}
