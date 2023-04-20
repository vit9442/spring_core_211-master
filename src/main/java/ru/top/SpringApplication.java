package ru.top;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.top.config.SpringConfig;
import ru.top.model.Food;
import ru.top.service.FoodService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class SpringApplication {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        FoodService service = context.getBean(FoodService.class);
        List<Food> allFood = service.findAll();
        System.out.println(allFood);
        System.out.println(service.findById(2));

    }
}
