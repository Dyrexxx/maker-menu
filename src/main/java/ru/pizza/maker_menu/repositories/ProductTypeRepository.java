package ru.pizza.maker_menu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pizza.maker_menu.models.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
}
