package com.example.OnlineStore.Service;

import com.example.OnlineStore.Models.Cart;
import com.example.OnlineStore.Models.CartItem;


import com.example.OnlineStore.aspect.ExecutionTime;
import com.example.OnlineStore.repository.CartRepository;
import com.example.OnlineStore.repository.ProductRepository;
import com.example.OnlineStore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
