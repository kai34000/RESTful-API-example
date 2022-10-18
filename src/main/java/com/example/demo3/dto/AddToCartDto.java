package com.example.demo3.dto;

import com.example.demo3.model.Cart;
import com.sun.istack.NotNull;

public class AddToCartDto {
    private Integer cart_item_id;
    private @NotNull String username;
    private @NotNull Long book_id;
    private @NotNull Integer quantity;

    public AddToCartDto(){
    }

    public AddToCartDto(Integer cart_item_id, String username, @NotNull Long book_id, @NotNull Integer quantity){
        this.cart_item_id = cart_item_id;
        this.username = username;
        this.book_id = book_id;
        this.quantity = quantity;
    }

    public AddToCartDto(Cart cart){
        this.cart_item_id = cart.getCart_id();
        this.book_id = cart.getBook_id();
        this.username = cart.getUsername();
        this.quantity = cart.getQuantity();
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + cart_item_id +
                ", username='" + username + '\'' +
                ", book_id=" + book_id +
                ", quantity=" + quantity +
                '}';
    }

    public Integer getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(Integer cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
