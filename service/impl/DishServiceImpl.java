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
}
