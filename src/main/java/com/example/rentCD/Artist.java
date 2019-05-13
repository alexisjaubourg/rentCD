package com.example.rentCD;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Artist {
	
	private long id;
	private String name;
	private Cd cd;
	
	public Artist() {
		super();
	}

	public Artist(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@ManyToOne
	public Cd getCd() {
		return cd;
	}

	public void setCd(Cd cd) {
		this.cd = cd;
	}

	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	
}
