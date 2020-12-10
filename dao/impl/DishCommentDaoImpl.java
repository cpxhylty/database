package dao.impl;

import dao.DishCommentDao;
import pojo.DishComment;
import pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
