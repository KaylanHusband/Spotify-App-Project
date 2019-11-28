package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (schema = "project2")
public class Song implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "song_id")
	private Integer songId;
	
	private String name;
	
	private String artist;
	
	@Column(length=50)
	private String spotifySongId;	
	
	public Song() {
		super();
	}
	
	public Song(Integer id) {
		super();
	}

	public Song(Integer songId, String spotifySongId) {
		super();
		this.songId = songId;
		this.spotifySongId = spotifySongId;
	}

	public Song(Integer songId, String spotifySongId, String name, String artist) {
		super();
		this.songId = songId;
		this.spotifySongId = spotifySongId;
		this.name = name;
		this.artist = artist;
	}

	public Song(String name, String artist, String spotifySongId) {
		super();
		this.spotifySongId = spotifySongId;
		this.name = name;
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", spotifySongId=" + spotifySongId + ", name=" + name + ", artist=" + artist
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((songId == null) ? 0 : songId.hashCode());
		result = prime * result + ((spotifySongId == null) ? 0 : spotifySongId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (songId == null) {
			if (other.songId != null)
				return false;
		} else if (!songId.equals(other.songId))
			return false;
		if (spotifySongId == null) {
			if (other.spotifySongId != null)
				return false;
		} else if (!spotifySongId.equals(other.spotifySongId))
			return false;
		return true;
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public String getSpotifySongId() {
		return spotifySongId;
	}

	public void setSpotifySongId(String spotifySongId) {
		this.spotifySongId = spotifySongId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	
}