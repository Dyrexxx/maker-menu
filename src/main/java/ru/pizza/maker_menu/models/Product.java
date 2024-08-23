package ru.pizza.maker_menu.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pizza.maker_menu.entities.Ingredient;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Product {
    private String name;
    private String description;
    private String urlImage;
    private int price;
    private String type;
    private List<Ingredient> ingredientList = new ArrayList<>();

    private ImageProduct imageProduct;

    public void addIngredient(Ingredient ingredient) {
        this.ingredientList.add(ingredient);
    }
}
