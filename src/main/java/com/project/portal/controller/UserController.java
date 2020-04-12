package com.project.portal.controller;

import com.project.portal.dto.user.UserRegistration;
import com.project.portal.model.User;
import com.project.portal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") long id) {
        return userService.findById(id);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/registration")
    public ModelAndView registerUser(@ModelAttribute UserRegistration userDto) {
        userService.registerUser(userDto);
        return new ModelAndView("success","user",userDto);
    }

    @GetMapping("/registration")
    public String registrationForm(WebRequest request, Model model) {
        UserRegistration userDto = new UserRegistration();
        model.addAttribute("user", userDto);
        return "register";
    }
}