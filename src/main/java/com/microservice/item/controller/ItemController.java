package com.microservice.item.controller;

import com.microservice.item.models.Item;
import com.microservice.item.models.Product;
import com.microservice.item.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    @Qualifier(value = "serviceFeign")
    private ItemService itemService;

    @GetMapping("/listar")
    public List<Item> listar() {
        return itemService.findAll();
    }

    @HystrixCommand(fallbackMethod = "alternativeMethod")
    @GetMapping("/obtener/{id}/quantity/{quantity}")
    public Item obtener(@PathVariable Long id, @PathVariable Integer quantity) {
        return itemService.findByID(id, quantity);
    }

    public Item alternativeMethod(Long id, Integer quantity) {
        Item item = new Item();
        Product product = new Product();
        item.setQuantity(quantity);
        product.setId(id);
        product.setName("Camara Sony");
        product.setPrice(500.00);
        item.setProduct(product);
        return item;
    }
}
