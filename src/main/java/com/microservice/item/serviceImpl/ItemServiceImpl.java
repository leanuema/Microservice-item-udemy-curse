package com.microservice.item.serviceImpl;

import com.microservice.item.models.Item;
import com.microservice.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public Item findByID(Long id, Integer quantity) {
        return null;
    }
}
