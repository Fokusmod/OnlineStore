package com.example.OnlineStore.controller;

import com.example.OnlineStore.Dto.CartDto;
import com.example.OnlineStore.Models.Cart;
import com.example.OnlineStore.Models.CartItem;
import com.example.OnlineStore.Models.Product;
import com.example.OnlineStore.Models.User;
import com.example.OnlineStore.Service.CartService;
import com.example.OnlineStore.Service.ProductService;
import com.example.OnlineStore.exception.ResourceNotFoundException;
import com.example.OnlineStore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

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
        return cartService.getCart(userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("This user-" + username + " not found")).getId());
    }

    @PostMapping("/cart")
    public void addProduct(@RequestBody CartDto cartDto) {
        Product product = productService.findById(cartDto.getProductId()).orElseThrow(() -> new ResourceNotFoundException("This product not found"));
        CartItem cartItem = CartItem.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .count(1L)
                .sum(product.getPrice())
                .build();
        User user = userRepository.findByUsername(cartDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("This user-" + cartDto.getUsername() + " not found"));
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
