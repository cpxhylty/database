package service;

import pojo.Vip;

import java.util.Date;
import java.util.List;

public interface VipService {
    List<Vip> getAllVips();

    List<Vip> searchByAccount(String account);

    void addVip(String account, Date registerTime, Date endTime, float money);

    void deleteVip(String account);
}
