package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.exceptions.ItemNFException;
import com.bezkoder.springjwt.models.Item;
import com.bezkoder.springjwt.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/items")
    Item newItem(@RequestBody Item newItem)
    {
        return itemRepository.save(newItem);
    }

    @GetMapping("/items")
    List<Item> getAllItems()
    {
        return itemRepository.findAll();
    }

    @GetMapping("/items/{id}")
    Item getItemById(@PathVariable Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNFException(id));
    }

    @PutMapping("/items/{id}")
    Item updateItem(@RequestBody Item newItem, @PathVariable Long id) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setName(newItem.getName());
                    item.setDescription(newItem.getDescription());
                    item.setImageUrl(newItem.getImageUrl());
                    return itemRepository.save(item);
                }).orElseThrow(() -> new ItemNFException(id));
    }

    @DeleteMapping("/items/{id}")
    String deleteItem(@PathVariable Long id){
        if(!itemRepository.existsById(id)){
            throw new ItemNFException(id);
        }
        itemRepository.deleteById(id);
        return  "Item with id "+id+" has been deleted success.";
    }



}
