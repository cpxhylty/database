package service.impl;

import dao.impl.SignDaoImpl;
import service.SignService;

import java.util.Date;

public class SignServiceImpl implements SignService {
    SignDaoImpl signDao = new SignDaoImpl();

    @Override
    public void addSign(String account, Date date) {
        signDao.addSign(account, date);
    }
}
