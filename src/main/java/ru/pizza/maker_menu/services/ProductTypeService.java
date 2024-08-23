package ru.pizza.maker_menu.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pizza.maker_menu.dao.ProductTypeDAO;
import ru.pizza.maker_menu.entities.ProductTypeEntity;
import ru.pizza.maker_menu.repositories.ProductTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductTypeService {
    private final ProductTypeDAO productTypeDAO;

    public List<ProductTypeEntity> index() {
        return productTypeDAO.findAll();
    }
}