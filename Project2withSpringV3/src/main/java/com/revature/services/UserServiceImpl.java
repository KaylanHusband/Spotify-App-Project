package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository ur;

	@Override
	public List<User> findAllUsers() {
		return ur.findAll();
	}
	
	@Override
	public User findUserById(Integer id) {
		return ur.findAllPlaylistsByUserId(id);
	}

	@Override
	public User findAllPlaylistsByUserId(Integer id) {
		return ur.findAllPlaylistsByUserId(id);
	}
	/*
	 * public List<Song> findSongsByPlaylistId(Integer id) {
		return sr.findSongsByPlaylist(new Playlist(id));
	}
	 */
	
	@Override
	public User addUser(User h) {
		return ur.save(h);
	}

	@Override
	public User updateUser(User h) {
		return ur.save(h);
	}

	@Override
	public User deleteUser(User h) {
		ur.delete(h);
		return h;
	}

	@Override
	public User findUserByUsernameAndPassword(String u, String p) {
		return ur.findUserByUsernameAndPassword(u, p);
	}

	@Override
	public User findUserByEmailAndPassword(String e, String p) {
		return ur.findUserByEmailAndPassword(e, p);
	}

	
	
}
