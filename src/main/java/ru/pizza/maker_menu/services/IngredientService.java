package ru.pizza.maker_menu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pizza.maker_menu.entities.Ingredient;
import ru.pizza.maker_menu.repositories.IngredientRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> index() {
        return ingredientRepository.findAll();
    }

    @Transactional
    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    @Transactional
    public void delete(int id) {
        ingredientRepository.deleteById(id);
    }

}
