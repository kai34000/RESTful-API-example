package com.example.demo3.repository;

import com.example.demo3.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

    List<Cart> findAllByUsername(String username);


}
