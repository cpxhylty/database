package service.impl;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import pojo.Customer;
import service.CustomerService;

import java.util.Date;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public Customer findCustomerByAccount(String account) {
        return customerDao.findCustomerByAccount(account);
    }

    @Override
    public void addCustomer(String account, Date register_time, String name) {
        customerDao.addCustomer(account, register_time, name);
    }
}
