package com.example.springbootapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapp.Exception.ResourceNotFoundException;
import com.example.springbootapp.Model.User;
import com.example.springbootapp.Respository.UserRepository;

@RestController
@RequestMapping("/api/v1/")
public class UsersController {

	@Autowired
	private UserRepository UserRepository;
	
	@GetMapping("/user")
	List<User> getAllUsers(){
		return UserRepository.findAll();
	}
	
	// Get User by Username
	@GetMapping("/users/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable(value = "username") String username) throws ResourceNotFoundException {
		User user = UserRepository.findById(username)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this username :: " + username));
		return ResponseEntity.ok().body(user);
	}


		
}
