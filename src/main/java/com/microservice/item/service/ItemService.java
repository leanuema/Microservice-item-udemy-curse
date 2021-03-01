package com.microservice.item.service;

import com.microservice.item.models.Item;
import com.microservice.item.models.Product;

import java.util.List;

public interface ItemService {

    public List<Item> findAll();
    public Item findByID(Long id, Integer quantity);
}
