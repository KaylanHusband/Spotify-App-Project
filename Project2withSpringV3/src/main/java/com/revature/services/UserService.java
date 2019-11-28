package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserService {

	public List<User> findAllUsers();
	public User findUserById(Integer id);
	public User findAllPlaylistsByUserId(Integer id);
	public User findUserByUsernameAndPassword(String u, String p);
	public User findUserByEmailAndPassword(String e, String p);
	public User addUser(User u);
	public User updateUser(User u);
	public User deleteUser(User u);
	
}
