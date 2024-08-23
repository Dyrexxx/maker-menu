package ru.pizza.maker_menu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pizza.maker_menu.entities.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
