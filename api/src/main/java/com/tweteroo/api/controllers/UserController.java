package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.UserRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

    final UserRepository userRepository;

		UserController(UserRepository userRepository) {
		    this.userRepository = userRepository;
		}

    @PostMapping
    public void createUser(@RequestBody @Valid UserDTO body) {
        UserModel user = new UserModel(body);
        userRepository.save(user);
    }
}