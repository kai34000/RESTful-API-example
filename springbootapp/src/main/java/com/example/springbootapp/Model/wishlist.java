package com.example.springbootapp.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "wishlist")
public class wishlist {
    

	
	@Id
	@Column(name = "id")
	String ID;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		this.ID = iD;
	}
	
	@Column(name = "username")
	String username;

	@Column(name = "isbn")
	String isbn;
	
	@Column(name = "wishlistname")
	String wishListName;
	
	
	public wishlist(String username, String isbn, String wishListName, User user) {
		super();
		this.username = username;
		this.isbn = isbn;
		this.wishListName = wishListName;
		this.user = user;
	}


	public wishlist() {
		super();
	}


	public String getWishListName() {
		return wishListName;
	}



	public void setWishListName(String wishListName) {
		this.wishListName = wishListName;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
	@JsonIgnore
	private User user;	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}