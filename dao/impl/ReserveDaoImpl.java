package dao.impl;

import dao.ReserveDao;
import pojo.Reserve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReserveDaoImpl implements ReserveDao {
    @Override
    public List<Integer> getVacantSeat(int month, int day, int type) {
        ArrayList<Integer> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "select seat_number from seat where seat_number not in" +
                    " (select seat_number from reserve where month=? and day=? and type=?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, month);
            preparedStatement.setInt(2, day);
            preparedStatement.setInt(3, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                res.add(resultSet.getInt("seat_number"));
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
    public void createReservation(String account, int month, int day, int type, int seatNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "insert into reserve values (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setInt(2, month);
            preparedStatement.setInt(3, day);
            preparedStatement.setInt(4, type);
            preparedStatement.setInt(5, seatNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("insert fail!!");
            e.printStackTrace();
        }
    }

    @Override
    public List<Reserve> getAllReserves() {
        ArrayList<Reserve> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "select * from reserve";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reserve reserve = new Reserve();
                reserve.setAccount(resultSet.getString("account"));
                reserve.setType(resultSet.getInt("type"));
                reserve.setMonth(resultSet.getInt("month"));
                reserve.setDay(resultSet.getInt("day"));
                reserve.setSeatNumber(resultSet.getInt("seat_number"));
                res.add(reserve);
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
    public List<Reserve> getReservesByDate(int month, int day) {
        ArrayList<Reserve> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "select * from reserve where month=? and day=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, month);
            preparedStatement.setInt(2, day);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reserve reserve = new Reserve();
                reserve.setAccount(resultSet.getString("account"));
                reserve.setType(resultSet.getInt("type"));
                reserve.setMonth(resultSet.getInt("month"));
                reserve.setDay(resultSet.getInt("day"));
                reserve.setSeatNumber(resultSet.getInt("seat_number"));
                res.add(reserve);
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
    public void deleteReserve(int month, int day, int type, int seatNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "delete from reserve where month=? and day=? and type=? and seat_number=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, month);
            preparedStatement.setInt(2, day);
            preparedStatement.setInt(3, type);
            preparedStatement.setInt(4, seatNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("delete fail!!");
            e.printStackTrace();
        }
    }
}
