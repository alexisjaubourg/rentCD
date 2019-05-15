package com.example.rentCD;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TrackRepository extends CrudRepository<Track, Long> {
	
	List<Track> findByTrackName(String name);
	
}