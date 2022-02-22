package com.pracownia.springapp.controllers;

import com.pracownia.springapp.entities.Phone;
import com.pracownia.springapp.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/phones")
    public List<Phone> getPhones(){
        return phoneService.getPhones();
    }
}
