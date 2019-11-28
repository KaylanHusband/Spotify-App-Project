package com.revature.services;

import java.util.List;

import com.revature.models.Song;

public interface SongService {

	public List<Song> findAllSongs();
	public List<Song> findSongsByPlaylistId(Integer id);
	public List<Song> findSongsByPlaylistByUserId(Integer id);
	public Song findSongById(Integer id);
	public Song addSong(Song u);
	public Song updateSong(Song u);
	public Song deleteSong(Song u);
	
}
