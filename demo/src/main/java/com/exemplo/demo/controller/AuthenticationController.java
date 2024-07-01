package com.exemplo.demo.controller;


import com.exemplo.demo.dto.LoginUserDto;
import com.exemplo.demo.dto.RegisterUserDto;
import com.exemplo.demo.entity.Users;
import com.exemplo.demo.responses.DefaultResponse;
import com.exemplo.demo.responses.LoginResponse;
import com.exemplo.demo.service.AuthenticationService;
import com.exemplo.demo.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<DefaultResponse> register(@RequestBody @Valid RegisterUserDto registerUserDto) {
        Users registeredUser = authenticationService.signup(registerUserDto);
        return DefaultResponse.build(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<DefaultResponse> authenticate(@RequestBody @Valid LoginUserDto loginUserDto) {
        Users authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return DefaultResponse.build(loginResponse, "Login successful.");
    }
}
