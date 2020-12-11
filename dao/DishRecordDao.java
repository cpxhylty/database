package dao;

import pojo.DishRecord;

import java.util.List;

public interface DishRecordDao {
    void orderDish(int orderNumber, String dishName, int dishNumber);

    void deleteDish(int orderNumber, String dishName, int deleteNumber);

    List<DishRecord> searchByOrderNumber(int orderNumber);
}
