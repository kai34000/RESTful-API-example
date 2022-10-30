package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.CreditCards;
import com.example.springboot.repository.CreditCardsRepository;
import com.example.springboot.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/")
public class CreditCardsController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CreditCardsRepository creditcardsRepository;
	
	@GetMapping("/Users/{username}/creditcards")
	  public ResponseEntity<List<CreditCards>> getAllCreditCardsByUsername(@PathVariable(value = "username") String username) throws ResourceNotFoundException {
	    if (!userRepository.existsById(username)) {
	      throw new ResourceNotFoundException("Not found User with username = " + username);
	    }

	    List<CreditCards> creditcard = creditcardsRepository.findByUsername(username);
	    return new ResponseEntity<>(creditcard, HttpStatus.OK);
	  }

	  @GetMapping("/creditcards/{credit_card_number}")
	  public ResponseEntity<CreditCards> getCreditCardsByUsername(@PathVariable(value = "credit_card_number") String credit_card_number) throws ResourceNotFoundException {
	    CreditCards creditcard = creditcardsRepository.findById(credit_card_number)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found CreditCard with username = " + credit_card_number));

	    return new ResponseEntity<>(creditcard, HttpStatus.OK);
	  }
	  
	  @PostMapping("/Users/{username}/creditcards")
	  public ResponseEntity<CreditCards> createCreditCard(@PathVariable(value = "username") String username,
	      @RequestBody CreditCards creditcardRequest) throws ResourceNotFoundException {
	    CreditCards creditcard = userRepository.findById(username).map(user -> {
	      creditcardRequest.setUser(user);
	      return creditcardsRepository.save(creditcardRequest);
	    }).orElseThrow(() -> new ResourceNotFoundException("Not found User with username = " + username));

	    return new ResponseEntity<>(creditcard, HttpStatus.CREATED);
	  }
}