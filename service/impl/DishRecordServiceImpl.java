package service.impl;

import dao.DishRecordDao;
import dao.impl.DishRecordDaoImpl;
import pojo.DishRecord;
import service.DishRecordService;

import java.util.List;

public class DishRecordServiceImpl implements DishRecordService {
    DishRecordDao dishRecordDao = new DishRecordDaoImpl();

    @Override
    public void orderDish(int orderNumber, String dishName, int dishNumber) {
        dishRecordDao.orderDish(orderNumber, dishName, dishNumber);
    }

    @Override
    public void deleteDish(int orderNumber, String dishName, int deleteNumber) {
        dishRecordDao.deleteDish(orderNumber, dishName, deleteNumber);
    }

    @Override
    public List<DishRecord> searchByOrderNumber(int orderNumber) {
        return dishRecordDao.searchByOrderNumber(orderNumber);
    }
}
