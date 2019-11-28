package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Playlist;
import com.revature.repositories.PlaylistRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	private PlaylistRepository pr;

	@Override
	public List<Playlist> findAllPlaylists() {
		return pr.findAll();
	}

	@Override
	public Playlist findPlaylistById(Integer id) {
		return pr.getOne(id);
	}

	@Override
	public Playlist addPlaylist(Playlist h) {
		return pr.save(h);
	}

	@Override
	public Playlist updatePlaylist(Playlist h) {
		return pr.save(h);
	}

	@Override
	public Playlist deletePlaylist(Playlist h) {
		pr.delete(h);
		return h;
	}

	
	@Override
	public List<Playlist> findPlaylistsByUserId(Integer id) {
		//return pr.findPlaylistsByUser(new User(id));
		return null;
	}

	
	
}
