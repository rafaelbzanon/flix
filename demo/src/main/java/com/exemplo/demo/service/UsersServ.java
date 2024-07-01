package com.exemplo.demo.service;

import com.exemplo.demo.entity.Users;
import com.exemplo.demo.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServ  {
    private final UsersRepository userRepository;

    public UsersServ(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> allUsers() {
        return new ArrayList<>(userRepository.findAll());
    }
}
