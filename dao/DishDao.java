package dao;

import pojo.Dish;
import pojo.Menu;

import java.util.List;

public interface DishDao {
    Dish findDishByName(String name);

    void addDish(String name,float price,int surplus,float vipPrice,String url);

    void deleteDish(String name);

    Menu getAllDish();

    void updateDish(String name,float price,int surplus,float vipPrice,String url);
}
