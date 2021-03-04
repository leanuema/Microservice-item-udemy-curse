package com.microservice.item.controller;

import com.microservice.item.models.Item;
import com.microservice.item.serviceImpl.ItemServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    //@Autowired
    //@Qualifier(value = "serviceFeign")
    private ItemServiceImpl itemService = null;

    @GetMapping("/listar")
    public List<Item> listar() {
        return itemService.findAll();
    }

    @GetMapping("/obtener/{id}/quantity/{quantity}")
    public Item obtener(@PathVariable Long id, @PathVariable Integer quantity) {
        return itemService.findByID(id, quantity);
    }
}
