package com.example.ecommerce.service;

import com.example.ecommerce.domain.CartItem;
import com.example.ecommerce.domain.Product;
import com.example.ecommerce.domain.ShoppingCart;
import com.example.ecommerce.domain.User;
import com.example.ecommerce.dto.AddToCartRequest;
import com.example.ecommerce.dto.CartItemDto;
import com.example.ecommerce.dto.ShoppingCartDto;
import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.ShoppingCartRepository;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository cartRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public ShoppingCartDto addItemToCart(Long userId, AddToCartRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        ShoppingCart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    ShoppingCart newCart = new ShoppingCart();
                    newCart.setUser(user);
                    return newCart;
                });

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + request.getProductId()));

        // Check if item is already in cart
        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(request.getProductId()))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + request.getQuantity());
        } else {
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setProduct(product);
            newItem.setQuantity(request.getQuantity());
            cart.getItems().add(newItem);
        }

        ShoppingCart savedCart = cartRepository.save(cart);
        return convertToDto(savedCart);
    }

    public Optional<ShoppingCartDto> getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId).map(this::convertToDto);
    }

    private ShoppingCartDto convertToDto(ShoppingCart cart) {
        ShoppingCartDto dto = new ShoppingCartDto();
        dto.setId(cart.getId());
        dto.setUserId(cart.getUser().getId());
        dto.setItems(cart.getItems().stream().map(this::convertCartItemToDto).collect(Collectors.toList()));
        return dto;
    }

    private CartItemDto convertCartItemToDto(CartItem cartItem) {
        CartItemDto dto = new CartItemDto();
        dto.setProductId(cartItem.getProduct().getId());
        dto.setProductName(cartItem.getProduct().getName());
        dto.setQuantity(cartItem.getQuantity());
        dto.setPrice(cartItem.getProduct().getPrice());
        return dto;
    }
}
