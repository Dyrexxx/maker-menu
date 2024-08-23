package ru.pizza.maker_menu.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pizza.maker_menu.dao.IngredientDAO;
import ru.pizza.maker_menu.entities.IngredientEntity;
import ru.pizza.maker_menu.repositories.IngredientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IngredientService {
    private final IngredientDAO ingredientDAO;

    public List<IngredientEntity> index() {
        return ingredientDAO.findAll();
    }

    @Transactional
    public void save(IngredientEntity ingredientEntity) {
        ingredientDAO.save(ingredientEntity);
    }

    @Transactional
    public void delete(int id) {
        ingredientDAO.deleteById(id);
    }

}
