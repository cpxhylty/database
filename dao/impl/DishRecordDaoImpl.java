package dao.impl;

import dao.DishRecordDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class DishRecordDaoImpl implements DishRecordDao {
    @Override
    public void orderDish(int orderNumber, String dishName, int dishNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "insert into dish_record values (?, ?, ?) on duplicate key update dish_number=dish_number+?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderNumber);
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
}
