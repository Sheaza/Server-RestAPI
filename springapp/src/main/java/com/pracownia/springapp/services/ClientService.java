package com.pracownia.springapp.services;

import com.pracownia.springapp.entities.Client;
import com.pracownia.springapp.entities.Order;
import com.pracownia.springapp.repositories.ClientRepository;
import com.pracownia.springapp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Iterable<Client> findAllClients(Integer pageNr, Integer howManyOnPage){
        return clientRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Client getClient(int id) {
        return clientRepository.findById(id).orElseThrow();
    }

    public Client saveClient(Client client){

        return clientRepository.save(client);
    }
    @Transactional
    public List<Client> findClientByName(String name){
        return clientRepository.findClientByName(name);
    }

    @Transactional
    public Client editClient(Client client){
        Client editedClient = clientRepository.findById(client.getId()).orElseThrow();
        editedClient.setAge(client.getAge());
        editedClient.setName(client.getName());
        editedClient.setSurname(client.getSurname());
        return editedClient;
    }


    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }
}
