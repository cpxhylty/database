package dao.impl;

import dao.CommentDao;
import pojo.Comment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public void addComment(int id, String dinnerTime, int type, String name, String content, int rating) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "INSERT INTO evaluate VALUES(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,dinnerTime);
            preparedStatement.setInt(3,type);
            preparedStatement.setString(4,name);
            preparedStatement.setString(5,content);
            preparedStatement.setInt(6,rating);
            int res = preparedStatement.executeUpdate();
            System.out.println("insert success!!");
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("insert fail!!");
            e.printStackTrace();
        }*/
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
