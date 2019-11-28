package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

//	public List<Song> findSongsByPlaylist(Playlist playlist);
	//public List<Song> findSongsByPlaylistUser(User user);
	
}
