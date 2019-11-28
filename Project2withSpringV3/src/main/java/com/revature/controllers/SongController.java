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
import com.revature.models.Song;
import com.revature.repositories.PlaylistRepository;
import com.revature.repositories.SongRepository;
import com.revature.services.PlaylistService;
import com.revature.services.SongService;

@RestController
@RequestMapping("/songs")
@CrossOrigin("http://localhost:4200")
public class SongController {


		@Autowired
		private SongService ss;
		
		@Autowired
		private PlaylistService ps;
		
		@Autowired
		private SongRepository sr;
		
		@Autowired
		private PlaylistRepository pr;

		@GetMapping
		public List<Song> getAll() {

			return ss.findAllSongs();
		}

		@GetMapping("/{id}")
		public Song getSongById(@PathVariable("id") Integer id) {
			return ss.findSongById(id);
		}
		
		@GetMapping("playlists/{id}")
		public List<Song> getSongsByPlaylistId(@PathVariable("id") Integer id) {
			return ss.findSongsByPlaylistId(id);
		}
		/*
		@GetMapping("playlists/users/{id}")
		public List<Song> getSongsByPlaylistIdByUserId(@PathVariable("id") Integer id) {
			return ss.findSongsByPlaylistByUserId(id);
		}
		*/
		
		@PostMapping
		public ResponseEntity<Song> addSong(@RequestParam("playlistId") Integer playlistId, @RequestParam("songName") String songName, @RequestParam("artistName") String artistName, @RequestParam("spotifySongId") String spotifySongId) {
			Song s = ss.addSong(new Song(songName, artistName, spotifySongId));
			//s.getSongId();
			Playlist p = ps.findPlaylistById(playlistId);
			List<Song> songs = p.getSongs();
			songs.add(s);
			sr.save(s);
			return new ResponseEntity<Song>(s, HttpStatus.CREATED);
		}
		
		
		/*
		 * 
		 *public ResponseEntity<Playlist> addPlaylist(@RequestParam("playlistName") String playlistName, @RequestParam("userId") Integer userId) {
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
		 * 
		 */
		
		
		
		
		/*
		@PostMapping
		public ResponseEntity<Song> addSong(@RequestParam("spotifySongId") String spotifySongId, @RequestParam("playlistId") Integer playlistId) {
			Song s = ss.addSong(new Song(spotifySongId, new Playlist(playlistId)));
			return new ResponseEntity<Song>(s, HttpStatus.CREATED);
		}
		*/

		@PutMapping("/{id}")
		public Song updateSong(@PathVariable("id") Integer id, @RequestBody Song Song) {
			Song.setSongId(id);
			return ss.updateSong(Song);
		}

		@DeleteMapping("/{id}")
		public Song deleteSong(@PathVariable("id") Integer id, @RequestParam("playlistId") Integer playlistId) {
			
			Playlist p = pr.getOne(playlistId);
			System.out.println("Playlist of song being deleted:\n" + p);
			
			List<Song> songs = p.getSongs();
			Song temp = null;
			for (Song s : songs) {
				System.out.println(s);
				if (s.getSongId() == id) {
					System.out.println("found song to remove");
					temp = s;
				}
				
			}
			
			songs.remove(temp);
			
			
			pr.save(p);
			
			
			return ss.deleteSong(new Song(id));
		}
	
}
