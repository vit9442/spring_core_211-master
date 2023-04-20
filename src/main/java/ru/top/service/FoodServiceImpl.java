package ru.top.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.top.dao.FoodDao;
import ru.top.model.Food;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class FoodServiceImpl implements FoodService {
    private final FoodDao foodDao;

    @Autowired  //Автоматическое внедререние зависимости
    public FoodServiceImpl (@Qualifier(value = "databaseDao")FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Override
    public List<Food> findAll() throws Exception {
        return foodDao.findAll();
    }

    @Override
    public Food findById(int id) throws Exception {
        return foodDao.findById(id).orElseThrow(
                () -> new NoSuchElementException(
                        String.format("No food found with id: %d", id)
                ));
    }

    @Override
    public Food save(Food food) throws Exception {
        return foodDao.save(food);
    }
}
