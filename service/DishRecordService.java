package service;

public interface DishRecordService {
    void orderDish(int orderNumber, String dishName, int dishNumber);

    void deleteDish(int orderNumber, String dishName, int deleteNumber);
}
