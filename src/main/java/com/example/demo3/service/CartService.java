package com.example.demo3.service;

import com.example.demo3.dto.AddToCartDto;
import com.example.demo3.dto.CartDto;
import com.example.demo3.exceptions.CartItemNotExistException;
import com.example.demo3.model.Book;
import com.example.demo3.model.Cart;
import com.example.demo3.model.CartCost;
import com.example.demo3.repository.CartRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }


    public void addToCart(AddToCartDto addToCartDto, String username){
        Cart cart = getAddToCartFromDto(addToCartDto,username);
        cartRepository.save(cart);
    }

    public Cart getAddToCartFromDto(AddToCartDto addToCartDto, String username){
        Cart cart = new Cart(addToCartDto,username);
        return cart;
    }



    public CartCost listCartItems(String username){
        List<Cart> cartList = cartRepository.findAllByUsername(username);
        List<CartDto> cartItems = new ArrayList<>();
        for(Cart cart: cartList){
            CartDto cartDto = getDtoFromCart(cart);
            cartItems.add(cartDto);
        }
        double totalCost = 0;
        for(CartDto cartDto:cartItems){
            totalCost += (cartDto.getBook().getPrice()*cartDto.getQuantity());
        }
        CartCost cartCost = new CartCost(cartItems,totalCost);
        return cartCost;
    }

    public static CartDto getDtoFromCart(Cart cart){
        CartDto cartDto = new CartDto(cart);
        return cartDto;
    }


    public void updateCartItem(Integer cartItemId, AddToCartDto cartDto, String username) throws CartItemNotExistException{
        if(!cartRepository.existsById(cartItemId))
            throw new CartItemNotExistException("Cart-Item's ID " + cartDto.getCart_item_id() + " is invalid.");

        Cart cart = getAddToCartFromDto(cartDto, username);

        cart.setUsername(username);
        cart.setCart_id(cartItemId);
        cart.setQuantity(cartDto.getQuantity());
        cart.setBook_id(cartDto.getBook_id());

        cartRepository.save(cart);
    }



    public void deleteCartItem(Integer itemId, String username) throws CartItemNotExistException {
        if(!cartRepository.existsById(itemId))
        throw new CartItemNotExistException("Cart-Item's ID " + itemId + " is invalid.");

        cartRepository.deleteById(itemId);
    }



}
