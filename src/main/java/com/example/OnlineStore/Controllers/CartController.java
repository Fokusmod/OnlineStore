package com.example.OnlineStore.Controllers;


import com.example.OnlineStore.Models.Cart;
import com.example.OnlineStore.Models.Product;
import com.example.OnlineStore.Service.CartService;
import com.example.OnlineStore.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CartController {

    private final ProductService productService;
    private final CartService cartService;


    @GetMapping("/cart")
    public Cart getCart(@RequestParam Long userId) {
        return cartService.getCart(userId);
    }



}
