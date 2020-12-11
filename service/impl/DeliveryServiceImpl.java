package service.impl;

import dao.DeliveryDao;
import dao.impl.DeliveryDaoImpl;
import pojo.Delivery;
import service.DeliveryService;

import java.util.List;

public class DeliveryServiceImpl implements DeliveryService {
    DeliveryDao deliveryDao = new DeliveryDaoImpl();

    @Override
    public List<Delivery> searchNotArranged() {
        return deliveryDao.searchNotArranged();
    }

    @Override
    public void takeOrder(int orderNumber, String deliveryMan) {
        deliveryDao.takeOrder(orderNumber, deliveryMan);
    }

    @Override
    public List<Delivery> searchInDelivery(String deliveryMan) {
        return deliveryDao.searchInDelivery(deliveryMan);
    }

    @Override
    public void finishOrder(int orderNumber) {
        deliveryDao.finishOrder(orderNumber);
    }

    @Override
    public List<Delivery> lookUpHistory(String deliveryMan) {
        return deliveryDao.lookUpDeliverHistory(deliveryMan);
    }
}
