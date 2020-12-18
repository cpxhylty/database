package dao.impl;

import dao.VipDao;
import pojo.Comment;
import pojo.Vip;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VipDaoImpl implements VipDao {
    @Override
    public List<Vip> getAllVips() {
        ArrayList<Vip> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM vip";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Vip vip = new Vip();
                vip.setAccount(resultSet.getString("account"));
                vip.setRegisterTime(new Date(resultSet.getTimestamp("register_time").getTime()));
                vip.setEndTime(new Date(resultSet.getTimestamp("end_time").getTime()));
                vip.setMoney(resultSet.getFloat("money"));
                res.add(vip);
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
    public List<Vip> searchByAccount(String account) {
        ArrayList<Vip> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM vip where account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Vip vip = new Vip();
                vip.setAccount(resultSet.getString("account"));
                vip.setRegisterTime(new Date(resultSet.getTimestamp("register_time").getTime()));
                vip.setEndTime(new Date(resultSet.getTimestamp("end_time").getTime()));
                vip.setMoney(resultSet.getFloat("money"));
                res.add(vip);
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
    public void addVip(String account, Date registerTime, Date endTime, float money) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "insert into vip values (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setTimestamp(2, new Timestamp(registerTime.getTime()));
            preparedStatement.setTimestamp(3, new Timestamp(endTime.getTime()));
            preparedStatement.setFloat(4, money);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("insert fail!!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVip(String account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "delete from vip where account=?";
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
    public void increaseMoney(String account, float money) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "update vip set money=money+? where account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, money);
            preparedStatement.setString(2, account);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("increase fail!!");
            e.printStackTrace();
        }
    }

    @Override
    public void decreaseMoney(String account, float money) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "update vip set money=money-? where account=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, money);
            preparedStatement.setString(2, account);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("decrease fail!!");
            e.printStackTrace();
        }
    }
}
