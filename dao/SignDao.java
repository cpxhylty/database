package dao;

import pojo.Staff;
import pojo.StaffSign;

import java.util.Date;
import java.util.List;

public interface SignDao {
    int checkDay(String account);

    void addSign(String account, Date date);

    /*List<StaffSign> getSignByStaff(Staff staff);*/
}
