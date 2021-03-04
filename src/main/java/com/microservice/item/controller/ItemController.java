package com.microservice.item.controller;

import com.microservice.item.client.ProductClientRest;
import com.microservice.item.models.Item;
import com.microservice.item.serviceImpl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ItemController {

    @Autowired
    //@Qualifier(value = "serviceFeign")
    private ProductClientRest itemService = null;

    @GetMapping("/listar")
    public List<Item> listar() {
        return itemService.listar().stream().map(product ->
                new Item(product, 1)).collect(Collectors.toList());
    }

    /*@GetMapping("/obtener/{id}/quantity/{quantity}")
    public Item obtener(@PathVariable Long id, @PathVariable Integer quantity) {
        return itemService.findByID(id, quantity);
    }*/
}
