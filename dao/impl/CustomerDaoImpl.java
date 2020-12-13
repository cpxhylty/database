package dao.impl;

import dao.CustomerDao;
import pojo.Customer;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public Customer findCustomerByAccount(String account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Customer customer = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM customer WHERE ACCOUNT = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = new Customer();
                customer.setAccount(resultSet.getString("account"));
                customer.setName(resultSet.getString("name"));
                customer.setRegister_time(new Date(resultSet.getTimestamp("register_time").getTime()));
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void addCustomer(String account, Date register_time, String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "INSERT INTO customer VALUES(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setTimestamp(2, new Timestamp(register_time.getTime()));
            preparedStatement.setString(3, name);
            int res = preparedStatement.executeUpdate();
            System.out.println("insert success!!");
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("insert fail!!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(String account) {

    }

    @Override
    public List<Customer> getAllCustomer() {
        return null;
    }
}
