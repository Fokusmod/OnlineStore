package com.example.OnlineStore.Service;

import com.example.OnlineStore.Models.Cart;
import com.example.OnlineStore.Models.CartItem;
import com.example.OnlineStore.Models.Product;
import com.example.OnlineStore.Models.User;
import com.example.OnlineStore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final Cart cart;

    @Cacheable(value = "cart", key = "#userId")
    public Cart getCart(Long userId) {
        cart.setUserId(userId);
        return cart;
    }


    @CachePut(value = "cart", key = "#userId")
    public Cart addToCart(Long userId, CartItem cartItem) {
        Cart cart = getCart(userId);
        cart.add(cartItem);
        return cart;
    }


    @CachePut(value = "cart", key = "#userId")
    public Cart deleteProduct(Long userId, CartItem cartItem) {
        Cart cart = getCart(userId);
        List<CartItem> cartItems = cart.getItems();
        for (CartItem item : cartItems) {
            if (item.getId().equals(cartItem.getId())) {
                cartItems.remove(item);
                break;
            }
        }
        return cart;
    }
}
