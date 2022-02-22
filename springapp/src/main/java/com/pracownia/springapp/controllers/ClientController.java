package com.pracownia.springapp.controllers;

import com.pracownia.springapp.entities.Client;
import com.pracownia.springapp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
    Obsługa get,post itp.
 */
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients/{page}")
    public Iterable<Client> findAllClients(Integer page, Integer limit){return clientService.findAllClients(page,limit);}

    @GetMapping("/clients")
    public List<Client> getClients(){return clientService.getClients();}

    @GetMapping("/clients/{id}")
    public Client getClient(Integer id){return clientService.getClient(id);}

    @GetMapping("/clients/{name}")
    public List<Client> findClientByName(String name){return clientService.findClientByName(name);}

    @PostMapping("/clients")
    public Client addClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/clients")
    public Client editClient(@RequestBody Client client){
        return clientService.editClient(client);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/clients/{id}")
    public void deleteClient(Integer id){
        clientService.deleteClient(id);
    }


}
