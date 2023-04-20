package ru.top.service;

import ru.top.model.Food;

import java.util.List;

//Слой обработки бизнес-логики (какая-то логика, исключения и т.д)
public interface FoodService {
    List<Food> findAll() throws Exception;
    Food findById(int id) throws Exception;
    Food save(Food food) throws Exception;
}
