package dao;

import pojo.Staff;
import pojo.StaffSign;

import java.util.List;

public interface SignDao {
    int checkDay(String account);

    void addSign(String account, int date);

    List<StaffSign> getSignByStaff(Staff staff);
}
