package com.project.portal.controller;

import com.project.portal.dto.UserRegistration;
import com.project.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    @ModelAttribute("user")
    public UserRegistration registrationForm() {
        return new UserRegistration();
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute("user") UserRegistration user, HttpServletRequest request, Errors errors) {
        userService.registerUser(user);
        return new ModelAndView("success");
    }
}
