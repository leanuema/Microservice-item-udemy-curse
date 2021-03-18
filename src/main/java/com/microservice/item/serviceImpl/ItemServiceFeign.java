package com.microservice.item.serviceImpl;

import com.microservice.item.client.ProductClientRest;
import com.microservice.item.models.Item;
import com.microservice.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
public class ItemServiceFeign implements ItemService {

    @Autowired
    private ProductClientRest restClient;

    @Override
    public List<Item> findAll() {
        return restClient.listar().stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findByID(Long id, Integer quantity) {
        return new Item(restClient.obtener(id), quantity);
    }
}
