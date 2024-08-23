package ru.pizza.maker_menu.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pizza.maker_menu.dao.parent.BaseOperationDB;
import ru.pizza.maker_menu.entities.IngredientEntity;
import ru.pizza.maker_menu.repositories.IngredientRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IngredientDAO implements BaseOperationDB<IngredientEntity, Integer> {
    private final IngredientRepository ingredientRepository;

    @Override
    public List<IngredientEntity> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public IngredientEntity findOneById(Integer id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public void save(IngredientEntity ingredientEntity) {
        ingredientRepository.save(ingredientEntity);
    }
}
