package dao.impl;

import dao.DishDao;
import pojo.Dish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DishDaoImpl implements DishDao {
    @Override
    public Dish findDishByName(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Dish dish = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM dish WHERE NAME = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                dish = new Dish();
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getDouble("price"));
                dish.setSurplus(resultSet.getInt("surplus"));
                dish.setVipPrice(resultSet.getDouble("vip_price"));
                dish.setUrl(resultSet.getString("url"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dish;
    }

    @Override
    public void addDish(String name, double price, int surplus, double vipPrice,String url) {

    }

    @Override
    public void deleteDish(String name) {

    }

    @Override
    public void getAllDish() {

    }

    @Override
    public void updateDish(String name, double price, int surplus, double vipPrice,String url) {

    }
}
