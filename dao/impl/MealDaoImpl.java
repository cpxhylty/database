package dao.impl;

import dao.MealDao;
import pojo.Comment;
import pojo.Meal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MealDaoImpl implements MealDao {
    @Override
    public List<Meal> findMealByAccount(String account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Meal> meals = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM meal WHERE account = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Meal meal = new Meal();
                meal.setOrderNumber(resultSet.getInt("order_number"));
                meal.setPrice(resultSet.getFloat("price"));
                meal.setWaiter(resultSet.getString("waiter"));
                meal.setSeatNumber(resultSet.getInt("seat_number"));
                meal.setUser(resultSet.getString("account"));
                meals.add(meal);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return meals;
    }

    @Override
    public List<Meal> getAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Meal> meals = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM meal";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Meal meal = new Meal();
                meal.setOrderNumber(resultSet.getInt("order_number"));
                meal.setPrice(resultSet.getFloat("price"));
                meal.setWaiter(resultSet.getString("waiter"));
                meal.setSeatNumber(resultSet.getInt("seat_number"));
                meal.setUser(resultSet.getString("user"));
                meals.add(meal);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return meals;
    }

    @Override
    public int getAllMealNum() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;
        List<Meal> meals = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT count(*) FROM meal";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            row = resultSet.getInt(1);
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            System.out.println("select fail!!");
            e.printStackTrace();
        }
        return row;
    }
}
