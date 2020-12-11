package dao.impl;

import dao.CommentDao;
import pojo.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
    @Override
    public List<Comment> findCommentByAccount(String account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Comment> comments = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM comment WHERE account = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setOrderNumber(resultSet.getInt("order_number"));
                comment.setTime(new Date(resultSet.getTimestamp("register_time").getTime()));
                comment.setName(resultSet.getString("name"));
                comment.setContent(resultSet.getString("content"));
                comment.setRating(resultSet.getInt("rating"));
                comment.setType(resultSet.getInt("type"));
                comments.add(comment);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public Comment findCommentByOrder(int orderNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Comment comment = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM comment WHERE order_number = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                comment.setOrderNumber(resultSet.getInt("order_number"));
                comment.setTime(new Date(resultSet.getTimestamp("register_time").getTime()));
                comment.setName(resultSet.getString("name"));
                comment.setContent(resultSet.getString("content"));
                comment.setRating(resultSet.getInt("rating"));
                comment.setType(resultSet.getInt("type"));
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comment;
    }

    @Override
    public void addComment(int orderNumber, int type, String name, String content, int rating, Date time) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "INSERT INTO comment VALUES(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderNumber);
            preparedStatement.setInt(2, type);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, content);
            preparedStatement.setInt(5, rating);
            preparedStatement.setTimestamp(6, new Timestamp(time.getTime()));
            int res = preparedStatement.executeUpdate();
            System.out.println("insert success!!");
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("insert fail!!");
            e.printStackTrace();
        }
    }

    @Override
    public void updateComment(int orderNumber, String name, String content, int rating, Date time) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "update comment set name=?, content=?, rating=?, time=? where order_number=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(5, orderNumber);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, content);
            preparedStatement.setInt(3, rating);
            preparedStatement.setTimestamp(4, new Timestamp(time.getTime()));
            int res = preparedStatement.executeUpdate();
            System.out.println("update success!!");
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("update fail!!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteComment(int orderNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "delete from comment where order_number=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderNumber);
            int res = preparedStatement.executeUpdate();
            System.out.println("delete success!!");
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("delete fail!!");
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> getAllComments() {
        ArrayList<Comment> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM comment";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setOrderNumber(resultSet.getInt("order_number"));
                comment.setType(resultSet.getInt("type"));
                comment.setRating(resultSet.getInt("rating"));
                comment.setContent(resultSet.getString("content"));
                comment.setTime(new Date(resultSet.getTimestamp("time").getTime()));
                comment.setName(resultSet.getString("name"));
                res.add(comment);
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
    public List<Integer> findHaveComment(String account) {
        ArrayList<Integer> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT order_number from meal where user=? intersect select order_number from comment where name in (select name from customer where account=?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                res.add(resultSet.getInt("order_number"));
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
