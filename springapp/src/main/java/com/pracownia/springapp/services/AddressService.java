package com.pracownia.springapp.services;

import com.pracownia.springapp.entities.Address;
import com.pracownia.springapp.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }
}
