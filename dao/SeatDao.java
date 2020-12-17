package dao;

import pojo.Seat;

import java.util.Date;
import java.util.List;

public interface SeatDao {
    List<Seat> getAllSeats();

    void startMeal(int seatNumber, String waiter, String account, Date date);

    void endMeal(int seatNumber);
}
