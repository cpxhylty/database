package dao.impl;

import dao.SignDao;
import pojo.Staff;
import pojo.StaffSign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignDaoImpl implements SignDao {
    @Override
    public int checkDay(String account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int day = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT count(*) as day FROM sign WHERE ACCOUNT = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                day = resultSet.getInt("day");
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return day;
    }

    @Override
    public void addSign(String account, Date date) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "insert into sign values (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account);
            preparedStatement.setDate(2, new java.sql.Date(date.getTime()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<StaffSign> getSignByStaff(Staff staff) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<StaffSign> staffSignList = new ArrayList<>();
        StaffSign staffSign = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM sign WHERE ACCOUNT = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,staff.getAccount());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                staffSign = new StaffSign();
                staffSign.setDate(resultSet.getDate("date"));
                staffSign.setStaff(staff);
                staffSignList.add(staffSign);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staffSignList;
    }
}
