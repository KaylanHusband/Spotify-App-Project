package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.UserService;

@RestController
@RequestMapping("/usernames")
@CrossOrigin
public class UsernameController {

	@Autowired
	private UserService us;
	
	@Autowired
	private UserRepository ur;
	
	//usernames/{like}
	@CrossOrigin
	@GetMapping("/{partialUsername}")
	public List<User> getUserById(@PathVariable("partialUsername")String partialUsername) {
		System.out.println("THIS IS MY partial username : "+partialUsername);
		return ur.findAllUsersByUsernameLike(partialUsername + "%");
	}
}
