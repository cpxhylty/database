package service;

import pojo.Meal;

import java.util.List;

public interface MealService {
    List<Meal> getAllMeal();

    float countPrice(int orderNumber);
}
