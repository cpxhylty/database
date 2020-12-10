package dao;

import pojo.Customer;

import java.util.List;

public interface CustomerDao {
    Customer findCustomerByAccount(String account);

    void addCustomer(String account,String regdate,String name);

    void deleteCustomer(String account);

    List<Customer> getAllCustomer();
}
