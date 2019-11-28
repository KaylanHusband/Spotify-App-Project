package com.revature.services;

import java.util.List;

import com.revature.models.Playlist;

public interface PlaylistService {

	public List<Playlist> findAllPlaylists();
	//public List<Playlist> findPlaylistsByUser(User u);
	public List<Playlist> findPlaylistsByUserId(Integer id);
	public Playlist findPlaylistById(Integer id);
	public Playlist addPlaylist(Playlist u);
	public Playlist updatePlaylist(Playlist u);
	public Playlist deletePlaylist(Playlist u);
	
}
