package com.example.demo3.model;

import com.example.demo3.dto.AddToCartDto;
import com.example.demo3.dto.CartDto;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cart_id;

    @Column(name="book_id")
    private Long book_id;

    @Column(name="username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "isbn",insertable = false, updatable = false)
    private Book book;

    private int quantity;


    public Cart(){
    }

    public Cart(CartDto cartDto, Book book, String username) {
        this.username = username;
        this.book = book;
        this.book_id = cartDto.getBook().getIsbn();
        this.quantity = cartDto.getQuantity();
    }

    public Cart(@NotNull String username, @NotNull Long book_id, int quantity) {
        this.username = username;
        this.book_id = book_id;
        this.quantity = quantity;
    }

    public Cart(CartDto cartDto, Book book) {
        this.book_id = cartDto.getBook().getIsbn();
        this.quantity = cartDto.getQuantity();
        this.book = book;
    }

    //?? used in CartService.getAddToCartFromDto
    public Cart(AddToCartDto addToCartDto, String username){
        this.username = username;
        this.book_id = addToCartDto.getBook_id();
        this.quantity = addToCartDto.getQuantity();
    }



    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
