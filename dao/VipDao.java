package dao;

import pojo.Vip;

import java.util.Date;
import java.util.List;

public interface VipDao {
    List<Vip> getAllVips();

    List<Vip> searchByAccount(String account);

    void addVip(String account, Date registerTime, Date endTime, float money);

    void deleteVip(String account);

    void increaseMoney(String account, float money);

    void decreaseMoney(String account, float money);
}
