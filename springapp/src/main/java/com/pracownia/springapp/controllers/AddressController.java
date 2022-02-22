package com.pracownia.springapp.controllers;

import com.pracownia.springapp.entities.Address;
import com.pracownia.springapp.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public List<Address> getAddresses(){
        return addressService.getAddresses();
    }
}
