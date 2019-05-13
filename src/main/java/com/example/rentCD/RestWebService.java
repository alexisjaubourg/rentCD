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
	
	@Autowired
	public RestWebService(CdRepository cdRepository, ArtistRepository artistRepository) {
		super();
		this.cdRepository = cdRepository;
		this.artistRepository = artistRepository;
	}
	
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
	
	@RequestMapping(value="/artist", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public Iterable<Artist> getArtist(){
		return artistRepository.findAll();
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
	
}