package com.pracownia.springapp.controllers;

import com.pracownia.springapp.entities.Client;
import com.pracownia.springapp.entities.Order;
import com.pracownia.springapp.services.ClientService;
import com.pracownia.springapp.services.OrderService;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Homepage controller.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "")
    String index() {
        return "Strona startowa";
    }


    @PostMapping(value = "generateModel", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        DateTime dateAndTime  = DateTime.now();

        return "Model Generated";
    }
}
