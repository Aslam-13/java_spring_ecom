package com.example.ecommerce.controller;

import com.example.ecommerce.dto.AddToCartRequest;
import com.example.ecommerce.dto.ShoppingCartDto;
import com.example.ecommerce.dto.UpdateCartItemRequest;
import com.example.ecommerce.dto.UpdateCartItemRequest;
import com.example.ecommerce.service.ShoppingCartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/carts")
public class ShoppingCartController {

    private final ShoppingCartService cartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ShoppingCartDto> getCartByUserId(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/user/{userId}/items")
    public ResponseEntity<ShoppingCartDto> addItemToCart(@PathVariable Long userId, @Valid @RequestBody AddToCartRequest request) {
        ShoppingCartDto updatedCart = cartService.addItemToCart(userId, request);
        return ResponseEntity.ok(updatedCart);
    }

    @PutMapping("/user/{userId}/items/{productId}")
    public ResponseEntity<ShoppingCartDto> updateItemQuantity(@PathVariable Long userId, @PathVariable Long productId, @Valid @RequestBody UpdateCartItemRequest request) {
        ShoppingCartDto updatedCart = cartService.updateItemQuantity(userId, productId, request.getQuantity());
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/user/{userId}/items/{productId}")
    public ResponseEntity<ShoppingCartDto> removeItemFromCart(@PathVariable Long userId, @PathVariable Long productId) {
        ShoppingCartDto updatedCart = cartService.removeItemFromCart(userId, productId);
        return ResponseEntity.ok(updatedCart);
    }
}
