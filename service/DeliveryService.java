package service;

import pojo.Delivery;

import java.util.List;

public interface DeliveryService {
    List<Delivery> searchNotArranged();

    void takeOrder(int orderNumber, String deliveryMan);

    List<Delivery> searchInDelivery(String deliveryMan);

    void finishOrder(int orderNumber);

    List<Delivery> lookUpHistory(String deliveryMan);
}
