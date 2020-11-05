package com.ensak.abdennour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensak.abdennour.entity.User;
import com.ensak.abdennour.exception.ResourceNotFoundException;
import com.ensak.abdennour.repository.UserRepository;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // get all users
    @GetMapping("/abdennour/all/")
    public List < User > getAllUsers() {
        return this.userRepository.findAll();
    }

    // get user by id
    @GetMapping("/abdennour/get/{id}")
    public User getUserById(@PathVariable(value = "id") long userId) {
        return this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
    }

    // create user
    @PostMapping(value = "/abdennour/add", consumes = "application/json")
    public User createUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    // update user
    @PostMapping(value = "/abdennour/update/{id}", consumes = "application/json")
    public User updateUser(@RequestBody User user, @PathVariable("id") long userId) {
        User existingUser = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        return this.userRepository.save(existingUser);
    }

    // delete user by id
    @GetMapping("/abdennour/delete/{id}")
    public ResponseEntity < User > deleteUser(@PathVariable("id") long userId) {
        User existingUser = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }
}