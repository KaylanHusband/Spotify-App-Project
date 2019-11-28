package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Playlist;
import com.revature.models.User;
import com.revature.services.PlaylistService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService us;
	
	@Autowired
	private PlaylistService ps;
	
	@CrossOrigin
	@GetMapping
	public List<User> getAll(){
		
		return us.findAllUsers();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id")Integer id) {
		//System.out.println("THIS IS MY ID: "+id);
		return us.findUserById(id);
	}
	
	@CrossOrigin
	@GetMapping("/{userid}/playlists")
	public User getAllPlayslistByUserId(@PathVariable("userid")Integer userid) {
		//System.out.println("THIS IS MY ID: "+id);
		return us.findAllPlaylistsByUserId(userid);
	}
	
	@CrossOrigin
	@GetMapping("/{userid}/playlists/{playlistid}")
	public Playlist getPlayslistByUserIdAndPlaylistId(@PathVariable("userid") Integer userid, @PathVariable("playlistid") Integer playlistid) {
		//System.out.println("THIS IS MY ID: "+id);
		//System.out.println(userid + " : " + playlistid);
		return ps.findPlaylistById(playlistid);
	}
	
	@GetMapping("/{userid}/playlists/{playlistid}/songs")
	public Playlist getSongstByUserIdAndPlaylistId(@PathVariable("userid") Integer userid, @PathVariable("playlistid") Integer playlistid) {
		//System.out.println("THIS IS MY ID: "+id);
		//System.out.println(userid + " : " + playlistid);
		return ps.findPlaylistById(playlistid);
	}
	
	/*
	@GetMapping("/{userid}/playlists/{playlistid}/songs/{songid}")
	public Playlist getSongstByUserIdAndPlaylistIdAndSongId(@PathVariable("userid") Integer userid, @PathVariable("playlistid") Integer playlistid, @PathVariable("songid") Integer songid) {
		//System.out.println("THIS IS MY ID: "+id);
		//System.out.println(userid + " : " + playlistid);
		return ps.findPlaById(songid);
	}
	*/
	
	/*
	@GetMapping("/{userid}/playlists/songs")
	public Playlist getPlayslistByUser(@PathVariable("userid") Integer userid, @PathVariable("playlistid") Integer playlistid) {
		//System.out.println("THIS IS MY ID: "+id);
		//System.out.println(userid + " : " + playlistid);
		return ps.findPlaylistById(playlistid);
	}
	*/
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User User){
		us.addUser(User);
		return new ResponseEntity<User>(User, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id")Integer id, @RequestBody User User) {
		User.setUserId(id);
		return us.updateUser(User);
	}
	
	@DeleteMapping("/{id}")
	public User deleteUser(@PathVariable("id")Integer id) {
		return us.deleteUser(new User(id));
	}
}
