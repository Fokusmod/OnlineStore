package com.example.backonlinestore.Service;

import com.example.backonlinestore.Models.Cart;
import com.example.backonlinestore.Models.CartItem;
import com.example.backonlinestore.aspect.ExecutionTime;
import com.example.backonlinestore.repository.CartRepository;
import com.example.backonlinestore.repository.ProductRepository;
import com.example.backonlinestore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;


    @ExecutionTime
    @Cacheable(value = "cart", key = "#userId")
    public Cart getCart(Long userId) {
        Cart cart = cartRepository.findById(userId).orElse(new Cart(userId, new ArrayList<>()));
        System.out.println(cart);
        return cart;

    }

    @ExecutionTime
    @CachePut(value = "cart", key = "#userId")
    public Cart addToCart(Long userId, CartItem cartItem) {
        Cart cart = getCart(userId);
        cart.getItems().add(cartItem);
        return cartRepository.save(cart);
    }

    @ExecutionTime
    @CachePut(value = "cart", key = "#userId")
    public Cart deleteProduct(Long userId, CartItem cartItem) {
        Cart cart = getCart(userId);
        cart.getItems().remove(cartItem);
        return cartRepository.save(cart);
    }

}
