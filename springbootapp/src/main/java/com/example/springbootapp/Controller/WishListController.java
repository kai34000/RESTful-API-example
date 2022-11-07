
package com.example.springbootapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapp.Exception.ResourceNotFoundException;
import com.example.springbootapp.Model.wishlist;
import com.example.springbootapp.Respository.WishlistRepository;
import com.example.springbootapp.Respository.UserRepository;
import com.example.springbootapp.Respository.BookRepository;

@RestController
@RequestMapping(value = "/users/{username}/wishList")
public class WishListController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository BookRepository;
	
	@Autowired
	private WishlistRepository wishlistRepository;
	
	@GetMapping
	  public ResponseEntity<List<wishlist>> getAllWishlistByUsername(@PathVariable(value = "username") String username) throws ResourceNotFoundException {
	    if (!userRepository.existsById(username)) {
	      throw new ResourceNotFoundException("Not found User with username = " + username);
	    }

	    List<wishlist> wishlist = wishlistRepository.findByUsername(username);
	    return new ResponseEntity<>(wishlist, HttpStatus.OK);
	  }
	
	



	
}
