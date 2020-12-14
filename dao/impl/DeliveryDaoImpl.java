package dao.impl;

import dao.DeliveryDao;
import pojo.Delivery;
import pojo.DishComment;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliveryDaoImpl implements DeliveryDao {
    static int orderNumber = 0;

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
            String sql = "update delivery set state=1, delivery_man=? where order_number=? and delivery_man=''";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, deliveryMan);
            preparedStatement.setInt(2, orderNumber);
            System.out.println(deliveryMan + " " + orderNumber);
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
            preparedStatement.setString(1, deliveryMan);
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
            System.out.println("select in delivery fail!!");
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
            preparedStatement.setString(1, deliveryMan);
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
            preparedStatement.setString(1, account);
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
    public void makeOrder(Date time, String account, float price, String address, int number, List<String> names, List<Integer> numbers) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            orderNumber--;
            String sql = "insert into delivery " +
                    "values (?, ?, ?, ?, ?, ?, 0)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderNumber);
            preparedStatement.setTimestamp(2, new Timestamp(time.getTime()));
            preparedStatement.setString(3, account);
            preparedStatement.setString(4,"");
            preparedStatement.setFloat(5, price);
            preparedStatement.setString(6, address);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            sql = "insert into dish_record values (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < number; i++) {
                String nameNow = names.get(i);
                int numberNow = numbers.get(i);
                preparedStatement.setInt(1, orderNumber);
                preparedStatement.setString(2, nameNow);
                preparedStatement.setInt(3, numberNow);
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("insert fail!!");
            e.printStackTrace();
        }
    }
}
