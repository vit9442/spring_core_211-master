package ru.top.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.top.model.Food;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DatabaseDao implements FoodDao {
    private final List<Food> data;
    @Autowired
   public DatabaseDao(DataSource dataSource){
        List<Food> dishes = new ArrayList<Food>();
        try (Connection con = dataSource.getConnection()) {
            System.out.println("Подключение произошло!");

            String query = "SELECT * FROM dishes;";
            PreparedStatement statement = con.prepareStatement(query);

            statement.execute();
            ResultSet res = statement.getResultSet();

            while(res.next()) {
                dishes.add(new Food(res.getInt("id"), res.getString("name"),null));
            }

        }
        catch (SQLException ex){
            System.out.println(ex);

        }
        data = dishes;

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
