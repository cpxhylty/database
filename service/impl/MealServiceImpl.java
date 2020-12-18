package service.impl;

import dao.MealDao;
import dao.impl.MealDaoImpl;
import pojo.Meal;

import java.util.List;

public class MealServiceImpl implements service.MealService {
    MealDao mealDao = new MealDaoImpl();

    @Override
    public List<Meal> getAllMeal() {
        return mealDao.getAll();
    }

    @Override
    public float countPrice(int orderNumber) {
        return mealDao.countPrice(orderNumber);
    }
}
