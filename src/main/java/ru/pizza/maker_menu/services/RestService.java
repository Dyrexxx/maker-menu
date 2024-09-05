package ru.pizza.maker_menu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.pizza.maker_menu.models.ProductModel;

import java.util.List;

@Service
public class RestService {
    private final RestTemplate restTemplate;

    @Autowired
    public RestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductModel> getProducts() {
        ProductModel[] productModelArray =
                restTemplate.getForEntity("http://PRODUCTS/products/view",
                                ProductModel[].class)
                        .getBody();
        return List.of(productModelArray);
    }
}