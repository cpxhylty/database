package dao.impl;

import dao.MealDao;
import pojo.Comment;
import pojo.Meal;

import java.sql.*;
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
                meal.setDate(resultSet.getDate("date"));
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
                meal.setUser(resultSet.getString("account"));
                meal.setDate(resultSet.getDate("date"));
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

    @Override
    public float countPrice(int orderNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        float price = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            /*String sql1 = "SELECT * FROM vip where account in (select account from meal where order_number=?)";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setInt(1, orderNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            String sql2;
            if (resultSet.next()) { //is VIP
                resultSet.close();
                sql2 = "select sum(vip_price) as total_price from dish where name in (select * from dish_record where order_number=?)";
            }
            else { //not VIP
                resultSet.close();
                sql2 = "select sum(price) as total_price from dish where name in (select * from dish_record where order_number=?)";
            }
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, orderNumber);
            resultSet = preparedStatement.executeQuery();
            price = resultSet.getFloat("total_price");
            resultSet.close();
            String sql3 = "update meal set price=? where order_number=?";
            preparedStatement = connection.prepareStatement(sql3);
            preparedStatement.setFloat(1, price);
            preparedStatement.setInt(2, orderNumber);
            preparedStatement.executeUpdate();
            resultSet.close();
            preparedStatement.close();*/
            String sql = "{call count_price(?)}";
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.setInt(1, orderNumber);
            callableStatement.registerOutParameter(2, Types.FLOAT);
            callableStatement.execute();
            price = callableStatement.getFloat(2);
            callableStatement.close();
            return price;
        } catch (Exception e) {
            System.out.println("count fail!!");
            e.printStackTrace();
        }
        return price;
    }
}
