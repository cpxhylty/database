package dao;

import pojo.Dish;

public interface DishDao {
    Dish findDishByName(String name);

    void addDish(String name,double price,int surplus,double vipPrice,String url);

    void deleteDish(String name);

    void getAllDish();

    void updateDish(String name,double price,int surplus,double vipPrice,String url);
}
