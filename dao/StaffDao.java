package dao;

import pojo.Staff;

import java.util.List;

public interface StaffDao {
    Staff findStaffByAccount(String account);

    void addStaff(String account,String name,float salary,int type);

    void deleteStaff(String account);

    List<Staff> getAllStaff();
}
