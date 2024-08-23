package ru.pizza.maker_menu.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageProduct {
    private String type;
    private byte[] file;
}
