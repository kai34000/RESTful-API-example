package com.example.springbootapp.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springbootapp.Model.wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<wishlist, String>{

	List<wishlist> findByUsername(String username);
    
	
} 