package service.impl;

import dao.VipDao;
import dao.impl.VipDaoImpl;
import pojo.Vip;
import service.VipService;

import java.util.Date;
import java.util.List;

public class VipServiceImpl implements VipService {
    VipDao vipDao = new VipDaoImpl();

    @Override
    public List<Vip> getAllVips() {
        return vipDao.getAllVips();
    }

    @Override
    public List<Vip> searchByAccount(String account) {
        return vipDao.searchByAccount(account);
    }

    @Override
    public void addVip(String account, Date registerTime, Date endTime, float money) {
        vipDao.addVip(account, registerTime, endTime, money);
    }

    @Override
    public void deleteVip(String account) {
        vipDao.deleteVip(account);
    }
}
