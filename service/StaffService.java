package service;

import pojo.Staff;

import java.util.List;

public interface StaffService {
    Staff findStaffByAccountService(String account);

    void addStaffService(String account,String name,float salary,int type);

    void deleteStaffService(String account);

    List<Staff> getAllStaffService();

    void changeSalary(String newSalary,String account);
}
