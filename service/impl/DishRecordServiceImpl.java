package service.impl;

import dao.DishRecordDao;
import dao.impl.DishRecordDaoImpl;
import service.DishRecordService;

public class DishRecordServiceImpl implements DishRecordService {
    DishRecordDao dishRecordDao = new DishRecordDaoImpl();

    @Override
    public void orderDish(int orderNumber, String dishName, int dishNumber) {
        dishRecordDao.orderDish(orderNumber, dishName, dishNumber);
    }
}
