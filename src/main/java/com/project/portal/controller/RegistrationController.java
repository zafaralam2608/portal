package com.project.portal.controller;

import com.project.portal.dto.UserRegistration;
import com.project.portal.exceptions.UserAlreadyExistsException;
import com.project.portal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RegistrationController {

    final UserService userService;

    @GetMapping("/register")
    @ModelAttribute("user")
    public UserRegistration registrationForm() {
        return new UserRegistration();
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute("user") @Valid UserRegistration user, HttpServletRequest request, Errors errors) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.registerUser(user);
            modelAndView.setViewName("success");
        } catch (UserAlreadyExistsException e) {
            modelAndView.addObject("error");
        }
        return modelAndView;
    }
}
