package ru.top.dao;

import ru.top.model.Food;

import java.util.List;
import java.util.Optional;

//CRUD - create read update delete
//Слой доступа к данным
public interface FoodDao {
    List<Food> findAll();
    Optional<Food> findById(int id);
    Food save(Food food);
}
