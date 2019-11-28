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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Playlist;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.PlaylistService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/playlists")
@CrossOrigin
public class PlaylistController {

	@Autowired
	private PlaylistService ps;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private UserRepository ur;

	@GetMapping
	public List<Playlist> getAll() {
		return ps.findAllPlaylists();
	}
	

	@GetMapping("/{id}")
	public Playlist getPlaylistById(@PathVariable("id") Integer id) {
		return ps.findPlaylistById(id);
	}
	
	/*
	@GetMapping("/users/{id}")
	public List<Playlist> getPlaylistsByUserId(@PathVariable("id") Integer id) {
		return ps.findPlaylistsByUserId(id);
	}

	*/
	/*
	@PostMapping
	public ResponseEntity<Playlist> addPlaylist(@RequestBody Playlist Playlist) {
		ps.addPlaylist(Playlist);
		return new ResponseEntity<Playlist>(Playlist, HttpStatus.CREATED);
	}
	*/
	@PostMapping
	public ResponseEntity<Playlist> addPlaylist(@RequestParam("playlistName") String playlistName, @RequestParam("userId") Integer userId) {
		Playlist p = ps.addPlaylist(new Playlist(playlistName));
		p.getPlaylistId();
		
		// This is how the associative tables are being populated automagically
		
		User u = us.findUserById(userId);
		List<Playlist> playlists = u.getPlaylists();
		playlists.add(p);
		ur.save(u);
		
		// This is how the associative tables are being populated automagically
		return new ResponseEntity<Playlist>(p, HttpStatus.CREATED);
	}
	/*
	@PostMapping
	public ResponseEntity<Playlist> addPlaylist(@RequestParam("playlistName") String playlistName, @RequestParam("userId") Integer userId) {
		Playlist p = ps.addPlaylist(new Playlist(playlistName, new User(userId)));
		return new ResponseEntity<Playlist>(p, HttpStatus.CREATED);
	}
	*/

	@PutMapping("/{id}")
	public Playlist updatePlaylist(@PathVariable("id") Integer id, @RequestBody Playlist Playlist) {
		Playlist.setPlaylistId(id);
		return ps.updatePlaylist(Playlist);
	}

	@DeleteMapping("/{id}")
	public Playlist deletePlaylist(@PathVariable("id") Integer id, @RequestParam("userId") Integer userid) {
		
		  // This is how the associative tables are being populated automagically
		
		User u = ur.findAllPlaylistsByUserId(userid);
		System.out.println("USER of playlist being deleted:\n" + u);
		
		List<Playlist> playlists = u.getPlaylists();
		Playlist temp = null;
		for (Playlist p : playlists) {
			System.out.println(p);
			if (p.getPlaylistId() == id) {
				System.out.println("found playlist to remove");
				temp = p;
			}
			
		}
		
		playlists.remove(temp);
		
		for (Playlist p : playlists) {
			System.out.println(p);
			
		}
		ur.save(u);
		
		// This is how the associative tables are being populated automagically
		 
		return ps.deletePlaylist(new Playlist(id));
	}
}
