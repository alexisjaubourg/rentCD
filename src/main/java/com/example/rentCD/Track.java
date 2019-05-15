package com.example.rentCD;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Track {
	
	private long trackId;
	private String trackName;
	private Cd cd;
	
	public Track() {
		super();
	}

	public Track(long trackId, String trackName) {
		super();
		this.trackId = trackId;
		this.trackName = trackName;
	}
	
	@ManyToOne
	public Cd getCd() {
		return cd;
	}

	public void setCd(Cd cd) {
		this.cd = cd;
	}

	@Id
	public long getTrackId() {
		return trackId;
	}
	public void setTrackId(long trackId) {
		this.trackId = trackId;
	}
	public String getTrackName() {
		return trackName;
	}
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	
	@Override
	public String toString() {
		return trackName;
	}
	
	
}
