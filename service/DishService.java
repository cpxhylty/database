package service;

import pojo.Menu;

public interface DishService {
    Menu getAllDish();

    void changeDish(String name,String price,String dishStock,String vipPrice);

    void addNewDish(String name,String price,String dishStock,String vipPrice,String url);
}
