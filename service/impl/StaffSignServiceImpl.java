package service.impl;

import dao.SignDao;
import dao.StaffDao;
import dao.impl.SignDaoImpl;
import dao.impl.StaffDaoImpl;
import pojo.Staff;
import pojo.StaffSign;
import service.StaffSignService;

public class StaffSignServiceImpl implements StaffSignService {
    StaffDao staffDao = new StaffDaoImpl();
    SignDao signDao = new SignDaoImpl();

    @Override
    public StaffSign findStaffAndSign(String account) {
        StaffSign staffSign = new StaffSign();
        Staff staff = staffDao.findStaffByAccount(account);
        int day = signDao.checkDay(account);
        staffSign.setStaff(staff);
        staffSign.setDay(day);
        return staffSign;
    }
}
