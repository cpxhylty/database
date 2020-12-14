package service.impl;

import dao.ReserveDao;
import dao.impl.ReserveDaoImpl;
import pojo.Reserve;
import service.ReserveService;

import java.util.List;

public class ReserveServiceImpl implements ReserveService {
    ReserveDao reserveDao = new ReserveDaoImpl();

    @Override
    public List<Integer> getVacantSeat(int month, int day, int type) {
        return reserveDao.getVacantSeat(month, day, type);
    }

    @Override
    public void createReservation(String account, int month, int day, int type, int seatNumber) {
        reserveDao.createReservation(account, month, day, type, seatNumber);
    }

    @Override
    public List<Reserve> getAllReserves() {
        return reserveDao.getAllReserves();
    }

    @Override
    public List<Reserve> getReservesByDate(int month, int day) {
        return reserveDao.getReservesByDate(month, day);
    }

    @Override
    public void deleteReserve(int month, int day, int type, int seatNumber) {
        reserveDao.deleteReserve(month, day, type, seatNumber);
    }
}
