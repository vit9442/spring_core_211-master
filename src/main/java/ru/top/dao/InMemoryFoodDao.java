package ru.top.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.top.model.Food;

import java.util.List;
import java.util.Optional;

@Component
public class InMemoryFoodDao implements FoodDao {
    private final List<Food> data;

    @Autowired
    public InMemoryFoodDao(List<Food> data) {
        this.data = data;
    }

    @Override
    public List<Food> findAll() {
        return data;
    }

    @Override
    public Optional<Food> findById(int id) {
        return data.stream()
                .filter(f -> f.getId() == id)
                .findAny();
    }

    @Override
    public Food save(Food food) {
        data.add(food);
        return food;
    }
}
