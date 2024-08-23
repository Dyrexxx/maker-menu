package ru.pizza.maker_menu.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        PIZZA, COFFEE;

    }
}