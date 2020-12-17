package service.impl;

import dao.DishDao;
import dao.impl.DishDaoImpl;
import pojo.Menu;
import service.DishService;

public class DishServiceImpl implements DishService {
    DishDao dishDao = new DishDaoImpl();

    @Override
    public Menu getAllDish() {
        return dishDao.getAllDish();
    }

    @Override
    public void changeDish(String name,String price, String dishStock, String vipPrice) {
        dishDao.changeDishPrice(name,Float.parseFloat(price),Integer.parseInt(dishStock),Float.parseFloat(vipPrice));
    }

    @Override
    public void addNewDish(String name, String price, String dishStock, String vipPrice, String url) {
        dishDao.addDish(name,Float.parseFloat(price),Integer.parseInt(dishStock),Float.parseFloat(vipPrice),url);
    }
}
