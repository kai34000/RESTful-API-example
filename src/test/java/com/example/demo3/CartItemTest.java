//package com.example.demo3;
//
//import com.example.demo3.model.Book;
//import com.example.demo3.model.Cart;
//import com.example.demo3.model.User;
//import com.example.demo3.repository.CartRepository;
//import com.example.demo3.repository.CartRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class CartItemTest {
//
//    @Autowired
//    private CartRepository cartItemRepo;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    public void testAddOneCartItem(){
//        Book book = entityManager.find(Book.class,9780345535658L);
//        User user = entityManager.find(User.class, "Elaw78");
//
//        Cart newCartItem = new Cart();
//        newCartItem.setUser(user);
//        newCartItem.setBook(book);
//        newCartItem.setQuantity(1);
//
//        Cart savedCartItem = cartItemRepo.save(newCartItem);
//
//        assert savedCartItem.getCart_id()>0;
//    }
//
//
//
//}

