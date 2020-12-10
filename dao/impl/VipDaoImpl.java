package dao.impl;

import dao.VipDao;
import pojo.Comment;
import pojo.Vip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
