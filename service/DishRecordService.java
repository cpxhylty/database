package service;

import pojo.DishRecord;

import java.util.List;

public interface DishRecordService {
    void orderDish(int orderNumber, String dishName, int dishNumber);

    void deleteDish(int orderNumber, String dishName, int deleteNumber);

    List<DishRecord> searchByOrderNumber(int orderNumber);
}
