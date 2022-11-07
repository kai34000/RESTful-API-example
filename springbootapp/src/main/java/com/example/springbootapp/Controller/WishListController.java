
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
	

//    @PostMapping
//    public ResponseEntity<String> createWishList(@PathVariable(value = "username")String email, @RequestBody wishlist wishList) {
//        List<wishlist> wishLists = wishlistRepository.getWishListsByUserEmailAndWishListName(email, wishList.getWishListName());
//        if(wishLists == null || wishLists.size()==0) {
//            if(wishList.getIsbn() == null) {
//                return new ResponseEntity<>("Wishlist should have at least one Book ISBN at the time of wishlist creation", HttpStatus.BAD_REQUEST);
//            }
//            if(BookRepository.findById(wishList.getIsbn()).isPresent()) {
//                return new ResponseEntity<>("The book with given ISBN is not present", HttpStatus.BAD_REQUEST);
//            }
//                wishList.setUsername(email);
//            wishlistRepository.save(wishList);
//            return new ResponseEntity<>("Wishlist with name "+ wishList.getWishListName() + " created", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Wishlist with name "+ wishList.getWishListName() + " is already present", HttpStatus.BAD_REQUEST);
//        }
//    }
	
	@PostMapping("/add")
	public wishlist createUser(@RequestBody wishlist wishlist) {
		return wishlistRepository.save(wishlist);
	}



	
}