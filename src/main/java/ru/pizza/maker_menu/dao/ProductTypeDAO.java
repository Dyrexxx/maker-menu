package ru.pizza.maker_menu.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pizza.maker_menu.dao.parent.BaseOperationDB;
import ru.pizza.maker_menu.entities.ProductTypeEntity;
import ru.pizza.maker_menu.repositories.ProductTypeRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductTypeDAO implements BaseOperationDB<ProductTypeEntity, Integer> {
    private final ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductTypeEntity> findAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductTypeEntity findOneById(Integer id) {
        return productTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        productTypeRepository.deleteById(id);
    }

    @Override
    public void save(ProductTypeEntity productTypeEntity) {
        productTypeRepository.save(productTypeEntity);
    }
}
