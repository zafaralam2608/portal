package com.project.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.portal.dto.UserRegistration;
import com.project.portal.exceptions.UserAlreadyExistsException;
import com.project.portal.service.UserService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class RegistrationController {

    /** The service dependency. */
    @Autowired
    private UserService userService;

    /**
     * Gets a template for registration.
     *
     * @return user registration resource
     */
    @GetMapping("/register")
    @ModelAttribute("user")
    public UserRegistration registrationForm() {
        return new UserRegistration();
    }

    /**
     * Saves a user registration.
     *
     * @param user the registration resource
     * @param request the servlet request
     * @param errors the error object
     * @return the completion message
     */
    @PostMapping("/register")
    public ModelAndView registerUser(
            @ModelAttribute("user") @Valid final UserRegistration user,
            final HttpServletRequest request, final Errors errors) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.registerUser(user);
            modelAndView.setViewName("success");
        } catch (UserAlreadyExistsException e) {
            log.error("Failed to register user. ", e);
            modelAndView.addObject("error");
        }
        return modelAndView;
    }
}
