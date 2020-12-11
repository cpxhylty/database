package service.impl;

import dao.CommentDao;
import dao.DeliveryDao;
import dao.MealDao;
import dao.impl.CommentDaoImpl;
import dao.impl.DeliveryDaoImpl;
import dao.impl.MealDaoImpl;
import pojo.CustomerHistory;
import service.CustomerHistoryService;

public class CustomerHistoryServiceImpl implements CustomerHistoryService {
    MealDao mealDao = new MealDaoImpl();
    DeliveryDao deliveryDao = new DeliveryDaoImpl();
    CommentDao commentDao = new CommentDaoImpl();

    @Override
    public CustomerHistory findCustomerHistory(String account) {
        CustomerHistory customerHistory = new CustomerHistory();
        customerHistory.setCommented(commentDao.findHaveComment(account));
        customerHistory.setMeals(mealDao.findMealByAccount(account));
        customerHistory.setDeliveries(deliveryDao.lookUpCustomerHistory(account));
        return customerHistory;
    }
}
