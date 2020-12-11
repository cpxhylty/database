package dao;

import pojo.Delivery;

import java.util.List;

public interface DeliveryDao {
    List<Delivery> searchNotArranged();

    void takeOrder(int orderNumber, String deliveryMan);

    List<Delivery> searchInDelivery(String deliveryMan);

    void finishOrder(int orderNumber);

    List<Delivery> lookUpHistory(String deliveryMan);
}
