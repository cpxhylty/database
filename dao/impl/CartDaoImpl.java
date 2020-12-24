package dao.impl;

import dao.CartDao;
import pojo.CartItem;
import pojo.DishRecord;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    @Override
    public void addIntoCart(String account, String dishName, int dishNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "insert into cart values (?, ?, ?) on duplicate key update dish_number=dish_number+?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
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
    public void deleteFromCart(String account, String dishName, int dishNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "delete from cart where dish_name=? and account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dishName);
            preparedStatement.setString(2, account);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("delete fail!!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByAccount(String account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "delete from cart where account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("delete fail!!");
            e.printStackTrace();
        }
    }

    @Override
    public List<CartItem> getAll(String account) {
        ArrayList<CartItem> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM cart where account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CartItem cartItem = new CartItem();
                cartItem.setAccount(resultSet.getString("account"));
                cartItem.setDishName(resultSet.getString("dish_name"));
                cartItem.setDishNumber(resultSet.getInt("dish_number"));
                res.add(cartItem);
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
    public float countPrice(String account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        float price = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "{call cart_count_price(?)}";
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.setString(1, account);
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
