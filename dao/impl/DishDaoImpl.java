package dao.impl;

import dao.DishDao;
import pojo.Dish;
import pojo.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DishDaoImpl implements DishDao {
    @Override
    public Dish findDishByName(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Dish dish = null;
        /*try {
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
        }*/
        return dish;
    }

    @Override
    public void addDish(String name, float price, int surplus, float vipPrice,String imgUrl) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "INSERT into dish values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setFloat(2,price);
            preparedStatement.setInt(3,surplus);
            preparedStatement.setFloat(4,vipPrice);
            preparedStatement.setString(5,imgUrl);
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDish(String name) {

    }

    @Override
    public Menu getAllDish() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Menu menu = new Menu();
        Dish dish = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM dish WHERE type = ? and surplus=1";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i < 6; i++) {
                ArrayList<Dish> subMenu = new ArrayList<>();
                preparedStatement.setInt(1, i);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    dish = new Dish();
                    dish.setName(resultSet.getString("name"));
                    dish.setPrice(resultSet.getFloat("price"));
                    dish.setSurplus(resultSet.getInt("surplus"));
                    dish.setVipPrice(resultSet.getFloat("vip_price"));
                    dish.setUrl(resultSet.getString("url"));
                    dish.setType(resultSet.getInt("type"));
                    subMenu.add(dish);
                }
                menu.addDishes(subMenu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public void updateDish(String name, float price, int surplus, float vipPrice,String url) {

    }

    @Override
    public List<Dish> getDishes() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Dish> dishes = new ArrayList<>();
        Dish dish = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM dish";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    dish = new Dish();
                    dish.setName(resultSet.getString("name"));
                    dish.setPrice(resultSet.getFloat("price"));
                    dish.setSurplus(resultSet.getInt("surplus"));
                    dish.setVipPrice(resultSet.getFloat("vip_price"));
                    dish.setUrl(resultSet.getString("url"));
                    dish.setType(resultSet.getInt("type"));
                    dishes.add(dish);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dishes;
    }

    @Override
    public void changeDishPrice(String name, float price, int surplus, float vipPrice) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "update dish set price = ?, surplus = ?, vip_price = ? where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            ArrayList<Dish> subMenu = new ArrayList<>();
            preparedStatement.setFloat(1, price);
            preparedStatement.setInt(2,surplus);
            preparedStatement.setFloat(3,vipPrice);
            preparedStatement.setString(4,name);
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
