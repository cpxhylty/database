package dao;

import pojo.Seat;

import java.util.List;

public interface SeatDao {
    List<Seat> getAllSeats();

    void startMeal(int seatNumber);

    void endMeal(int seatNumber);
}
