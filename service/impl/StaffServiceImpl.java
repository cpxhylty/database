package service.impl;

import dao.StaffDao;
import dao.impl.StaffDaoImpl;
import pojo.Staff;
import service.StaffService;

import java.util.List;

public class StaffServiceImpl implements StaffService {
    StaffDao staffDao = new StaffDaoImpl();


    @Override
    public Staff findStaffByAccountService(String account) {
        Staff staff = staffDao.findStaffByAccount(account);
        return staff;
    }

    @Override
    public void addStaffService(String account, String name, String salary, int type) {
        staffDao.addStaff(account, name, salary, type);
    }

    @Override
    public void deleteStaffService(String account) {
        staffDao.deleteStaff(account);
    }

    @Override
    public List<Staff> getAllStaffService() {
        List<Staff> staffs = staffDao.getAllStaff();
        return staffs;
    }
}
