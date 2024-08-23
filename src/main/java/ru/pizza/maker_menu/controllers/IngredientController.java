package ru.pizza.maker_menu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pizza.maker_menu.entities.Ingredient;
import ru.pizza.maker_menu.services.IngredientService;

import java.util.List;

@RestController
@RequestMapping("/maker/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getIngredients() {
        return new ResponseEntity<>(ingredientService.index(), HttpStatus.OK);
    }
}
