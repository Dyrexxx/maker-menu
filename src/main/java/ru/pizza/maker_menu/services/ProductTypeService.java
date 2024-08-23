package ru.pizza.maker_menu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pizza.maker_menu.models.ProductType;
import ru.pizza.maker_menu.repositories.ProductTypeRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductTypeService {
    private final ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public List<ProductType> index() {
        return productTypeRepository.findAll();
    }

}