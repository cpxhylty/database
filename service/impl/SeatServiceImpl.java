package service.impl;

import dao.SeatDao;
import dao.impl.SeatDaoImpl;
import pojo.Seat;
import service.SeatService;

import java.util.Date;
import java.util.List;

public class SeatServiceImpl implements SeatService {
    SeatDao seatDao = new SeatDaoImpl();

    @Override
    public List<Seat> getAllSeats() {
        return seatDao.getAllSeats();
    }

    @Override
    public void startMeal(int seatNumber, String waiter, String account, Date date) {
        seatDao.startMeal(seatNumber, waiter, account, date);
    }

    @Override
    public void endMeal(int seatNumber) {
        seatDao.endMeal(seatNumber);
    }
}
