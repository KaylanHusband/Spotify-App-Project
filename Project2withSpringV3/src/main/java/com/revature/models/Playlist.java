package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table (schema = "project2")
public class Playlist implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "playlist_id")
	private Integer playlistId;
	
	private String name;

	/*
	 *  private Foo parentNode;

    @OneToMany(mappedBy = "parentNode", cascade = CascadeType.REMOVE)
	 */
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="playlist_song",
			schema="project2",
			joinColumns={@JoinColumn(name="playlist_id")},
			inverseJoinColumns={@JoinColumn(name="song_id")})
	private List<Song> songs = new ArrayList<>();
	
	public Playlist() {
		super();
	}
	
	public Playlist(Integer id) {
		super();
		this.playlistId = id;
	}

	public Playlist(Integer playlistId, List<Song> songs, String name) {
		super();
		this.playlistId = playlistId;
		this.songs = songs;
		this.name = name;
	}

	public Playlist(String playlistName) {
		this.name = playlistName;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((playlistId == null) ? 0 : playlistId.hashCode());
		result = prime * result + ((songs == null) ? 0 : songs.hashCode());
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
		Playlist other = (Playlist) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (playlistId == null) {
			if (other.playlistId != null)
				return false;
		} else if (!playlistId.equals(other.playlistId))
			return false;
		if (songs == null) {
			if (other.songs != null)
				return false;
		} else if (!songs.equals(other.songs))
			return false;
		return true;
	}

	public Integer getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(Integer playlistId) {
		this.playlistId = playlistId;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Playlist [playlistId=" + playlistId + ", name=" + name + ", songs=" + songs + "]";
	}

	
	
	
}