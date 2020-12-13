package dao.impl;

import dao.StaffDao;
import pojo.Staff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffDaoImpl implements StaffDao {
    @Override
    public Staff findStaffByAccount(String account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Staff staff = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM staff WHERE ACCOUNT = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                staff = new Staff();
                staff.setAccount(resultSet.getString("account"));
                staff.setName(resultSet.getString("name"));
                staff.setSalary(resultSet.getFloat("salary"));
                staff.setType(resultSet.getInt("type"));
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staff;
    }

    @Override
    public void addStaff(String account, String name, float salary, int type) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "INSERT INTO staff VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,name);
            preparedStatement.setFloat(3,salary);
            preparedStatement.setInt(4,type);
            int res = preparedStatement.executeUpdate();
            System.out.println("insert success!!");
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("insert fail!!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStaff(String account) {

    }

    @Override
    public List<Staff> getAllStaff() {
        ArrayList<Staff> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM staff";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Staff staff = new Staff();
                staff.setAccount(resultSet.getString("account"));
                staff.setName(resultSet.getString("name"));
                staff.setSalary(resultSet.getFloat("salary"));
                staff.setType(resultSet.getInt("type"));
                res.add(staff);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
