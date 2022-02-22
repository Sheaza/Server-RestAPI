package com.pracownia.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pracownia.springapp.exception.ResourceNotFoundException;
import com.pracownia.springapp.entities.User;
import com.pracownia.springapp.entities.UserPrincipal;
import com.pracownia.springapp.repositories.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(Authentication authentication) {
        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
        return userRepository.findById(userDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userDetails.getId()));
    }

    @GetMapping(value = "/data", produces = "application/json")
    @PreAuthorize("hasRole('USER')")
    public String getUserSecretData(Authentication authentication) {
        return "Now server can reveal user's secret data";
    }
}
