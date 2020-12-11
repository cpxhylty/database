package dao.impl;

import dao.DeliveryDao;
import pojo.Delivery;
import pojo.DishComment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliveryDaoImpl implements DeliveryDao {
    @Override
    public List<Delivery> searchNotArranged() {
        ArrayList<Delivery> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM delivery where state=0";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Delivery delivery = new Delivery();
                delivery.setOrderNumber(resultSet.getInt("order_number"));
                delivery.setTime(new Date(resultSet.getTimestamp("time").getTime()));
                delivery.setAccount(resultSet.getString("account"));
                delivery.setDeliveryMan(resultSet.getString("delivery_man"));
                delivery.setPrice(resultSet.getFloat("price"));
                delivery.setAddress(resultSet.getString("address"));
                delivery.setState(resultSet.getInt("state"));
                res.add(delivery);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            System.out.println("select fail!!");
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void takeOrder(int orderNumber, String deliveryMan) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "update delivery set state=1, delivery_man=? where order_number=? and delivery_man is null";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, deliveryMan);
            preparedStatement.setInt(2, orderNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Delivery> searchInDelivery(String deliveryMan) {
        ArrayList<Delivery> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM delivery where state=1 and delivery_man=?";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.setString(1, deliveryMan);
            while (resultSet.next()) {
                Delivery delivery = new Delivery();
                delivery.setOrderNumber(resultSet.getInt("order_number"));
                delivery.setTime(new Date(resultSet.getTimestamp("time").getTime()));
                delivery.setAccount(resultSet.getString("account"));
                delivery.setDeliveryMan(resultSet.getString("delivery_man"));
                delivery.setPrice(resultSet.getFloat("price"));
                delivery.setAddress(resultSet.getString("address"));
                delivery.setState(resultSet.getInt("state"));
                res.add(delivery);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            System.out.println("select fail!!");
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void finishOrder(int orderNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "update delivery set state=2 where order_number=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Delivery> lookUpDeliverHistory(String deliveryMan) {
        ArrayList<Delivery> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM delivery where state=2 and delivery_man=?";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.setString(1, deliveryMan);
            while (resultSet.next()) {
                Delivery delivery = new Delivery();
                delivery.setOrderNumber(resultSet.getInt("order_number"));
                delivery.setTime(new Date(resultSet.getTimestamp("time").getTime()));
                delivery.setAccount(resultSet.getString("account"));
                delivery.setDeliveryMan(resultSet.getString("delivery_man"));
                delivery.setPrice(resultSet.getFloat("price"));
                delivery.setAddress(resultSet.getString("address"));
                delivery.setState(resultSet.getInt("state"));
                res.add(delivery);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            System.out.println("select fail!!");
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Delivery> lookUpCustomerHistory(String account) {
        ArrayList<Delivery> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM delivery where state=2 and account=?";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.setString(1, account);
            while (resultSet.next()) {
                Delivery delivery = new Delivery();
                delivery.setOrderNumber(resultSet.getInt("order_number"));
                delivery.setTime(new Date(resultSet.getTimestamp("time").getTime()));
                delivery.setAccount(resultSet.getString("account"));
                delivery.setDeliveryMan(resultSet.getString("delivery_man"));
                delivery.setPrice(resultSet.getFloat("price"));
                delivery.setAddress(resultSet.getString("address"));
                delivery.setState(resultSet.getInt("state"));
                res.add(delivery);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            System.out.println("select fail!!");
            e.printStackTrace();
        }
        return res;
    }
}
