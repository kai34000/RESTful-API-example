package com.example.demo3.controller;

import com.example.demo3.model.Book;
import com.example.demo3.model.Cart;
import com.example.demo3.model.CartCost;
import com.example.demo3.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;


    //display all items in cart and total cost of them
    @GetMapping
    public CartCost getCartCost(@RequestParam String username){
        return cartService.listCartItems(username);
    }



    @PostMapping
    public void addToCart(@RequestBody Cart cart, @RequestParam String username){
        cartService.addToCart(cart,username);
    }


    //delete a book from user's cart
    @DeleteMapping(path="{cartItemId}")
    public void deleteCartItem(@PathVariable("cartItemId") Integer itemId, @RequestParam String username){
        cartService.deleteCartItem(itemId,username);
    }


    //let user update quantity of an existing book item in cart
    @PutMapping("/update/{cartItemId}")
    public void updateCartItem(@PathVariable("cartItemId")Integer itemId, @RequestBody Cart cart, @RequestParam String username){
        cartService.updateCartItem(itemId,cart, username);
    }



}
