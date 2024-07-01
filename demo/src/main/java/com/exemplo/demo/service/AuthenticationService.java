package com.exemplo.demo.service;

import com.exemplo.demo.dto.LoginUserDto;
import com.exemplo.demo.dto.RegisterUserDto;
import com.exemplo.demo.entity.Users;
import com.exemplo.demo.repository.UsersRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UsersRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UsersRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users signup(RegisterUserDto input) {
        Users user = new Users();
        user.setEmail(input.email());
        user.setPassword(passwordEncoder.encode(input.password()));

        return userRepository.save(user);
    }

    public Users authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.password()
                )
        );

        return userRepository.findByEmail(input.email())
                .orElseThrow();
    }
}
