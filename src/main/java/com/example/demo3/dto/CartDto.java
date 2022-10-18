package com.example.demo3.dto;

import com.example.demo3.model.Book;
import com.example.demo3.model.Cart;

public class CartDto {
    private Integer cart_item_id;
    private String username;
    private Integer quantity;
    private Book book;

    public CartDto() {
    }

    public CartDto(Cart cart){
        this.cart_item_id = cart.getCart_id();
        this.username = cart.getUsername();
        this.quantity = cart.getQuantity();
        this.book = cart.getBook();
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "cart_item_id=" + cart_item_id +
                ", username='" + username + '\'' +
                ", quantity=" + quantity +
                ", book name" + book.getBook_name() +
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
