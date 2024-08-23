package ru.pizza.maker_menu.dao.parent;

import java.util.List;

public interface BaseOperationDB<T, V> {
    List<T> findAll();
    T findOneById(V id);
    void deleteById(V id);
    void save(T t);
}