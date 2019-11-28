package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

	//public List<Playlist> findAllPlaylistsByUserId(Integer id);
}
