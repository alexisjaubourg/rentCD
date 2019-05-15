package com.example.rentCD;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cd {
	
	private List<Artist> artists = new ArrayList<Artist>();
	private List<Track> tracks = new ArrayList<Track>();
	
	private long id;
	private String name;

	public Cd() {
		super();
	}

	public Cd(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@OneToMany(mappedBy="cd", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
	
	@OneToMany(mappedBy="cd", cascade=CascadeType.ALL)
	@JsonIgnore
	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Cd [artists=" + artists + ", id=" + id + ", name=" + name + ", tracks=" + tracks + "]";
	}
	
}
