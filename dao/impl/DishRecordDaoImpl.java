package dao.impl;

import dao.DishRecordDao;
import pojo.DishComment;
import pojo.DishRecord;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DishRecordDaoImpl implements DishRecordDao {
    @Override
    public void orderDish(int orderNumber, String dishName, int dishNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "insert into dish_record values (?, ?, ?) on duplicate key update dish_number=dish_number+?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderNumber);
            preparedStatement.setString(2, dishName);
            preparedStatement.setInt(3, dishNumber);
            preparedStatement.setInt(4, dishNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("insert fail!!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDish(int orderNumber, String dishName, int deleteNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "update dish_record set dish_number=dish_number-? where dish_name=? and order_number=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, deleteNumber);
            preparedStatement.setString(2, dishName);
            preparedStatement.setInt(3, orderNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("update fail!!");
            e.printStackTrace();
        }
    }

    @Override
    public List<DishRecord> searchByOrderNumber(int orderNumber) {
        ArrayList<DishRecord> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM dish_record where order_number=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DishRecord dishRecord = new DishRecord();
                dishRecord.setOrderNumber(resultSet.getInt("order_number"));
                dishRecord.setDishName(resultSet.getString("dish_name"));
                dishRecord.setDishNumber(resultSet.getInt("dish_number"));
                res.add(dishRecord);
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
    public List<DishRecord> getAllDishRecord() {
        ArrayList<DishRecord> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM dish_record";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DishRecord dishRecord = new DishRecord();
                dishRecord.setOrderNumber(resultSet.getInt("order_number"));
                dishRecord.setDishName(resultSet.getString("dish_name"));
                dishRecord.setDishNumber(resultSet.getInt("dish_number"));
                res.add(dishRecord);
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
