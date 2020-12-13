package dao.impl;

import dao.EvaluateDao;
import pojo.Evaluate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EvaluateDaoImpl implements EvaluateDao {
    @Override
    public Evaluate findEvaluateById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Evaluate evaluate = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM evaluate WHERE ACCOUNT = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                evaluate = new Evaluate();
                evaluate.setId(resultSet.getInt("id"));
                evaluate.setDinnerTime(resultSet.getString("dinner_time"));
                evaluate.setName(resultSet.getString("name"));
                evaluate.setContent(resultSet.getString("content"));
                evaluate.setRating(resultSet.getInt("rating"));
                evaluate.setType(resultSet.getInt("type"));
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return evaluate;
    }

    @Override
    public void addEvaluate(int id, String dinnerTime, int type, String name, String content, int rating) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
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
        }
    }

    @Override
    public List<Evaluate> getAllEvaluate() {
        ArrayList<Evaluate> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM evaluate";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Evaluate evaluate = new Evaluate();
                evaluate.setId(resultSet.getInt("id"));
                evaluate.setType(resultSet.getInt("type"));
                evaluate.setRating(resultSet.getInt("rating"));
                evaluate.setContent(resultSet.getString("content"));
                evaluate.setDinnerTime(resultSet.getString("dinner_time"));
                evaluate.setName(resultSet.getString("name"));
                res.add(evaluate);
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
