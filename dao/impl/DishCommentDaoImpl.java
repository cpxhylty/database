package dao.impl;

import dao.DishCommentDao;
import pojo.DishComment;
import pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DishCommentDaoImpl implements DishCommentDao {
    @Override
    public List<DishComment> getAllDishComments() {
        ArrayList<DishComment> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM dish_comment";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DishComment dishComment = new DishComment();
                dishComment.setTime(new Date(resultSet.getTimestamp("time").getTime()));
                dishComment.setUser(resultSet.getString("user"));
                dishComment.setDish(resultSet.getString("dish"));
                dishComment.setContent(resultSet.getString("content"));
                res.add(dishComment);
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
    public List<DishComment> findDishCommentByAccount(String account) {
        ArrayList<DishComment> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM dish_comment where user=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DishComment dishComment = new DishComment();
                dishComment.setTime(new Date(resultSet.getTimestamp("time").getTime()));
                dishComment.setUser(resultSet.getString("user"));
                dishComment.setDish(resultSet.getString("dish"));
                dishComment.setContent(resultSet.getString("content"));
                res.add(dishComment);
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
    public void addComment(Date time, String account, String dish, String content) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "INSERT INTO dish_comment VALUES(?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, new Timestamp(time.getTime()));
            preparedStatement.setString(2, account);
            preparedStatement.setString(3, dish);
            preparedStatement.setString(4, content);
            int res = preparedStatement.executeUpdate();
            System.out.println("insert success!!");
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("insert fail!!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteComment(Date time, String account, String dish) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "delete from dish_comment where time=? and user=?, dish=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, new Timestamp(time.getTime()));
            preparedStatement.setString(2, account);
            preparedStatement.setString(3, dish);
            int res = preparedStatement.executeUpdate();
            System.out.println("delete success!!");
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("delete fail!!");
            e.printStackTrace();
        }
    }
}
