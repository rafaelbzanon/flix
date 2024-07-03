package com.exemplo.demo.controller;

import com.exemplo.demo.dto.AddItemRequest;
import com.exemplo.demo.dto.CartDTO;
import com.exemplo.demo.entity.Cart;
import com.exemplo.demo.service.CartsServ;
import com.exemplo.demo.util.SecurityUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartsServ cartsServ;

    @Autowired
    public CartController(CartsServ cartsServ) {
        this.cartsServ = cartsServ;
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody @Valid AddItemRequest request) {
        try {
            String userEmail = SecurityUtils.getLoggedInUserEmail();
            Cart cart = cartsServ.addItemToCart(userEmail, request.getMediaId());
            return ResponseEntity.ok(cart);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<CartDTO>> listCarts() {
        try {
            String userEmail = SecurityUtils.getLoggedInUserEmail();
            List<CartDTO> carts = cartsServ.getCartsForUser(userEmail);
            return ResponseEntity.ok(carts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/remove/{mediaId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Integer mediaId) {
        try {
            String userEmail = SecurityUtils.getLoggedInUserEmail();
            cartsServ.removeItemFromCart(userEmail, mediaId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
