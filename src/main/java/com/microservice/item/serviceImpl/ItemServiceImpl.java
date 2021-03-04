package com.microservice.item.serviceImpl;

import com.microservice.item.models.Item;
import com.microservice.item.models.Product;
import com.microservice.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate restClient;

    @Override
    public List<Item> findAll() {
        List<Product> productList = Arrays.asList(
                restClient.getForObject("http://localhost:8001/listar", Product[].class));
        return productList.stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findByID(Long id, Integer quantity) {
        Map<String, String> pathVariable = new HashMap<>();
        pathVariable.put("id", id.toString());
        Product product = restClient.getForObject("http://localhost:8001/obtener/{id}", Product.class, pathVariable);
        return new Item(product, quantity);
    }
}
