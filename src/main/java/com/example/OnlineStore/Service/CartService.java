package com.example.OnlineStore.Service;

import com.example.OnlineStore.Models.Cart;
import com.example.OnlineStore.Models.CartItem;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Cacheable(value = "cart")
    public Cart getCart(Long userId) {
        Cart cart = new Cart();
        CartItem item = CartItem.builder()
                .id(1L)
                .title("Cheese")
                .count(2L)
                .price(100.)
                .sum(200.)
                .build();

        cart.setUserId(userId);
        cart.setItems(List.of(item));
        System.out.println("Yes");
        return cart;
    }

    @CacheEvict(value = "cart")
    public void clear(Long userId) {}
}
