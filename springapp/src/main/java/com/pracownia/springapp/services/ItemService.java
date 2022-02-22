package com.pracownia.springapp.services;

import com.pracownia.springapp.entities.Item;
import com.pracownia.springapp.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItems(){
        return itemRepository.findAll();
    }
}
