package dao.impl;

import dao.SeatDao;
import pojo.DishComment;
import pojo.Seat;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeatDaoImpl implements SeatDao {
    static int orderNumber = 0;

    @Override
    public List<Seat> getAllSeats() {
        ArrayList<Seat> res = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "SELECT * FROM seat";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Seat seat = new Seat();
                seat.setSeatNumber(resultSet.getInt("seat_number"));
                seat.setState(resultSet.getInt("state"));
                seat.setVolume(resultSet.getInt("volume"));
                seat.setType(resultSet.getInt("type"));
                seat.setOrderNumber(resultSet.getInt("order_number"));
                res.add(seat);
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
    public void startMeal(int seatNumber, String waiter, String account, Date date) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            orderNumber++;
            int order_now = orderNumber;
            /*String sql = "update seat set state=1, order_number=? where seat_number=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order_now);
            preparedStatement.setInt(2, seatNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            String sql2 = "insert into meal values (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, order_now);
            preparedStatement.setFloat(2, 0);
            preparedStatement.setString(3, waiter);
            preparedStatement.setInt(4, seatNumber);
            preparedStatement.setString(5, account);
            preparedStatement.setDate(6, new java.sql.Date(date.getTime()));
            preparedStatement.executeUpdate();
            preparedStatement.close();*/
            String sql = "{?=call start_meal(?, ?, ?, ?, ?, ?)}";
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.setInt(1, order_now);
            callableStatement.setFloat(2, 0);
            callableStatement.setString(3, waiter);
            callableStatement.setInt(4, seatNumber);
            callableStatement.setString(5, account);
            callableStatement.setDate(6, new java.sql.Date(date.getTime()));
            callableStatement.execute();
            callableStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endMeal(int seatNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cygl?serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root");
            String sql = "update seat set state=0, order_number=null where seat_number=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, seatNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
