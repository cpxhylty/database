package dao;

import pojo.Customer;

import java.util.Date;
import java.util.List;

public interface CustomerDao {
    Customer findCustomerByAccount(String account);

    void addCustomer(String account, Date register_time, String name);

    void deleteCustomer(String account);

    List<Customer> getAllCustomer();
}
