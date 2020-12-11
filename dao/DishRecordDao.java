package dao;

public interface DishRecordDao {
    void orderDish(int orderNumber, String dishName, int dishNumber);

    void deleteDish(int orderNumber, String dishName, int deleteNumber);
}
