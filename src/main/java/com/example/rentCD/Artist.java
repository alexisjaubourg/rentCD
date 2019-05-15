package com.example.rentCD;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Artist {
	
	private long artistId;
	private String artistName;
	private Cd cd;
	
	public Artist() {
		super();
	}

	public Artist(long artistId, String artistName) {
		super();
		this.artistId = artistId;
		this.artistName = artistName;
	}
	
	@ManyToOne
	public Cd getCd() {
		return cd;
	}

	public void setCd(Cd cd) {
		this.cd = cd;
	}
	
	@Id
	public long getArtistId() {
		return artistId;
	}
	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	@Override
	public String toString() {
		return artistName;
	}
	
	
}
