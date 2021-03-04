package com.microservice.item.client;

import com.microservice.item.models.Item;
import com.microservice.item.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductClientRest {

    @GetMapping(value = "/listar")
    List<Product> listar();

    @GetMapping("/obtener/{id}/quantity/{quantity}")
    Item obtener(@PathVariable Long id, @PathVariable Integer quantity);
}
