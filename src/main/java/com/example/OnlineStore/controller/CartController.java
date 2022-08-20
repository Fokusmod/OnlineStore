package com.example.OnlineStore.controller;

import com.example.OnlineStore.Dto.CartDto;
import com.example.OnlineStore.Models.Cart;
import com.example.OnlineStore.Models.CartItem;
import com.example.OnlineStore.Models.Product;
import com.example.OnlineStore.Models.User;
import com.example.OnlineStore.Service.CartService;
import com.example.OnlineStore.Service.ProductService;
import com.example.OnlineStore.Service.UserService;
import com.example.OnlineStore.exception.ResourceNotFoundException;
import com.example.OnlineStore.repository.UserRepository;
import com.example.OnlineStore.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;
    private final UserRepository userRepository;


    @GetMapping("/cart/{username}")
    @ResponseStatus(HttpStatus.OK)
    public Cart showCart(@PathVariable String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("This user-" + username + " not found"));
        return cartService.getCart(user.getId());
    }

    @PostMapping("/cart")
    public void addProduct(@RequestBody CartDto cart) {
        Product product = productService.findById(cart.getProductId()).orElseThrow(() -> new ResourceNotFoundException("This product not found"));
        CartItem cartItem = CartItem.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .count(1L)
                .sum(product.getPrice())
                .build();
        User user = userRepository.findByUsername(cart.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("This user-" + cart.getUsername() + " not found"));
        cartService.addToCart(user.getId(), cartItem);

    }

    @PutMapping("/cart")
    public void deleteProduct(@RequestBody CartDto cart) {
        Product product = productService.findById(cart.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("This product not found"));
        CartItem cartItem = CartItem.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .count(1L)
                .sum(product.getPrice())
                .build();
        User user = userRepository.findByUsername(cart.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("This user-" + cart.getUsername() + " not found"));
        cartService.deleteProduct(user.getId(), cartItem);
    }


}
