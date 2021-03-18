package com.microservice.item.client;

import com.microservice.item.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductClientRest {

    @GetMapping(value = "/listar")
    List<Product> listar();

    @GetMapping("/obtener/{id}")
    Product obtener(@PathVariable Long id);
}
