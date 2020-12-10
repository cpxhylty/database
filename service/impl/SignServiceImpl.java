package service.impl;

import dao.impl.SignDaoImpl;
import service.SignService;

public class SignServiceImpl implements SignService {
    SignDaoImpl signDao = new SignDaoImpl();

    @Override
    public void addSignService(String account, int date) {
        signDao.addSign(account, date);
    }
}
