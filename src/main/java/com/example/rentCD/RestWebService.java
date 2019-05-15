package com.example.rentCD;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWebService {

	CdRepository cdRepository;
	ArtistRepository artistRepository;
	TrackRepository trackRepository;
	
	@Autowired
	public RestWebService(CdRepository cdRepository, ArtistRepository artistRepository, TrackRepository trackRepository) {
		super();
		this.cdRepository = cdRepository;
		this.artistRepository = artistRepository;
		this.trackRepository = trackRepository;
	}
	
	// CD functions
	@RequestMapping(value="/cd", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public Iterable<Cd> getCd(){
		return cdRepository.findAll();
	}
	
	@RequestMapping(value = "/cd/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Optional<Cd> aCd(@PathVariable("id") long id) throws Exception{
		return cdRepository.findById(id);
	} 
	
	@RequestMapping(value = "/cd", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addCd(@RequestBody Cd cd) throws Exception{
		System.out.println(cd);
		cdRepository.save(cd);
	}
	
	@RequestMapping(value = "/cd/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void getBack(@PathVariable("id") long id) throws Exception{
		cdRepository.deleteById(id);
	} 
	
	// Artist functions
	@RequestMapping(value="/artist", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public Iterable<Artist> getArtist(){
		return artistRepository.findAll();
	}
	
	@RequestMapping(value = "/artist/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Optional<Artist> aArtist(@PathVariable("id") long id) throws Exception{
		return artistRepository.findById(id);
	} 
	
	@RequestMapping(value = "/artist", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addArtist(@RequestBody Artist artist) throws Exception{
		System.out.println(artist);
		artistRepository.save(artist);
	}
	
	// Track functions
	@RequestMapping(value="/track", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public Iterable<Track> getTrack(){
		return trackRepository.findAll();
	}
	
	@RequestMapping(value = "/track/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Optional<Track> aTrack(@PathVariable("id") long id) throws Exception{
		return trackRepository.findById(id);
	} 
	
	@RequestMapping(value = "/track", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addTrack(@RequestBody Track track) throws Exception{
		System.out.println(track);
		trackRepository.save(track);
	}
}