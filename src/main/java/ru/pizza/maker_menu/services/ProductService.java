package ru.pizza.maker_menu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.pizza.maker_menu.models.Product;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private final RestTemplate restTemplate;

    @Autowired
    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> getProducts() {
        Product[] productArray =
                restTemplate.getForEntity("http://localhost:8082/products/view",
                                Product[].class)
                        .getBody();
        return List.of(productArray);
    }
}