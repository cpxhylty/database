package dao;

import pojo.Meal;

import java.util.List;

public interface MealDao {
    List<Meal> findMealByAccount(String account);

    List<Meal> getAll();

    int getAllMealNum();

    float countPrice(int orderNumber);
}
