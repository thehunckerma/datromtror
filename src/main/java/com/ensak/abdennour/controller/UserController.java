package com.ensak.abdennour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.ensak.abdennour.entity.User;
import com.ensak.abdennour.exception.ResourceNotFoundException;
import com.ensak.abdennour.repository.UserRepository;

@Controller
//@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    // @RequestMapping(value = "message", method = RequestMethod.GET)
    // public String messages(Model model) {
    //     model.addAttribute("messages", messageRepository.findAll());
    //     return "message/list";
    // }
    // get all users
    @GetMapping("/abdennour/all")
    public String getAllUsers(Model model) {
        List<User> users = this.userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("tab","home");
        return "index";
    }

    // get user by id
    @PostMapping("/abdennour/show/{id}")
    public String getUserById(@PathVariable(value = "id") long userId, Model model) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        List<User> users = this.userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("showUser", user);
        model.addAttribute("tab","show");
        return "index";
    }

    // create user
    @PostMapping("/abdennour/add")
    public String createUser(
        @RequestParam("firstName") String firstName, 
        @RequestParam("lastName") String lastName, 
        @RequestParam("email") String email, 
        @RequestParam("phone") String phone,
        Model model) 
        {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhone(phone);
            this.userRepository.save(user);
            List<User> users = this.userRepository.findAll();
            model.addAttribute("users", users);
            model.addAttribute("createUser", user);
            model.addAttribute("createUserMessage", "user created successfuly");
            model.addAttribute("tab","add");
            return "index";
        }

    // update user
    @PostMapping("/abdennour/update/{id}")
    public String updateUser(@RequestParam("firstName") String firstName, 
        @RequestParam("lastName") String lastName, 
        @RequestParam("email") String email, 
        @RequestParam("phone") String phone, 
        @PathVariable("id") long userId,
        Model model
        ) {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhone(phone);

            User existingUser = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            this.userRepository.save(existingUser);
            List<User> users = this.userRepository.findAll();
            model.addAttribute("users", users);
            model.addAttribute("updateUser", existingUser);
            model.addAttribute("updateUserMessage", "User updated successfully");
            model.addAttribute("tab","update");
            return "index";
    }

    // delete user by id
    @PostMapping("/abdennour/delete/{id}")
    public String deleteUser(@PathVariable("id") long userId, Model model) {
        User existingUser = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        this.userRepository.delete(existingUser);
        List<User> users = this.userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("deleteUser", existingUser);
        model.addAttribute("deleteUserMessage", "User deleted successfully");
        model.addAttribute("tab","delete");
        return "index";
    }
}