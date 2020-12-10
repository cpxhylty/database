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
    public Comment findCommentById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Comment comment = null;
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM evaluate WHERE ACCOUNT = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                comment = new Comment();
                comment.setOrder_name(resultSet.getInt("id"));
                comment.setDinnerTime(resultSet.getString("dinner_time"));
                comment.setName(resultSet.getString("name"));
                comment.setContent(resultSet.getString("content"));
                comment.setRating(resultSet.getInt("rating"));
                comment.setType(resultSet.getInt("type"));
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return comment;
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
                comment.setOrder_name(resultSet.getInt("order_number"));
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
}
