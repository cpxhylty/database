package service.impl;

import dao.VipDao;
import dao.impl.VipDaoImpl;
import pojo.Vip;
import service.VipService;

import java.util.List;

public class VipServiceImpl implements VipService {
    VipDao vipDao = new VipDaoImpl();

    @Override
    public List<Vip> getAllVips() {
        return vipDao.getAllVips();
    }
}
