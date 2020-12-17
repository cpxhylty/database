package dao;

import pojo.Delivery;

import java.util.Date;
import java.util.List;

public interface DeliveryDao {
    List<Delivery> searchNotArranged();

    void takeOrder(int orderNumber, String deliveryMan);

    List<Delivery> searchInDelivery(String deliveryMan);

    void finishOrder(int orderNumber);

    List<Delivery> lookUpDeliverHistory(String deliveryMan);

    List<Delivery> lookUpCustomerHistory(String account);

    void makeOrder(Date time, String account, float price, String address, int number, List<String> names, List<Integer> numbers);

    int getDeliveryNum();

    List<Delivery> getAllDelivery();
}
