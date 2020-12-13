package service;

import pojo.Customer;

import java.util.Date;

public interface CustomerService {
    Customer findCustomerByAccount(String account);

    void addCustomer(String account, Date register_time, String name);
}
