package com.exemplo.demo.service;

import com.exemplo.demo.dto.CartDTO;
import com.exemplo.demo.dto.MediaDTO;
import com.exemplo.demo.entity.Cart;
import com.exemplo.demo.entity.Media;
import com.exemplo.demo.entity.Users;
import com.exemplo.demo.repository.CartsRepository;
import com.exemplo.demo.repository.MediaRepository;
import com.exemplo.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartsServ {

    @Autowired
    private CartsRepository cartsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MediaRepository mediaRepository;

    @Transactional
    public Cart addItemToCart(String userEmail, Integer mediaId) {
        Users user = usersRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        Media media = mediaRepository.findById(mediaId).orElseThrow(() -> new RuntimeException("Media not found"));

        Optional<Cart> cartOptional = cartsRepository.findByUser(user);
        Cart cart;
        if (cartOptional.isPresent()) {
            cart = cartOptional.get();
        } else {
            cart = new Cart();
            cart.setUser(user);
            cart.setCartItems(new ArrayList<>());
        }

        cart.getCartItems().add(media);
        return cartsRepository.save(cart);
    }

    public List<CartDTO> getCartsForUser(String userEmail) {
        Users user = usersRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        List<Cart> carts = cartsRepository.findAllByUser(user);

        return carts.stream().map(this::convertToCartDTO).collect(Collectors.toList());
    }

    private CartDTO convertToCartDTO(Cart cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(cart.getId());
        cartDTO.setCreatedAt(cart.getCreatedAt());
        List<MediaDTO> cartItems = cart.getCartItems().stream().map(MediaDTO::fromEntity).collect(Collectors.toList());
        cartDTO.setCartItems(cartItems);
        return cartDTO;
    }

    @Transactional
    public void removeItemFromCart(String userEmail, Integer mediaId) {
        Users user = usersRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        Media media = mediaRepository.findById(mediaId).orElseThrow(() -> new RuntimeException("Media not found"));

        Cart cart = cartsRepository.findByUser(user).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.getCartItems().remove(media);
        cartsRepository.save(cart);
    }

}
