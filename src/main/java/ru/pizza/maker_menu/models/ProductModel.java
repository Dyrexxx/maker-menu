package ru.pizza.maker_menu.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pizza.maker_menu.entities.IngredientEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductModel {
    private String name;
    private String description;
    private String urlImage;
    private int price;
    private String type;
    private List<IngredientEntity> ingredientEntityList = new ArrayList<>();

    private ImageModel imageModel;

    public void addIngredient(IngredientEntity ingredientEntity) {
        this.ingredientEntityList.add(ingredientEntity);
    }
}
