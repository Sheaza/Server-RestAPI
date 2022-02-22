package com.pracownia.springapp.services;

import com.pracownia.springapp.entities.Phone;
import com.pracownia.springapp.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    public List<Phone> getPhones(){
        return phoneRepository.findAll();
    }
}
