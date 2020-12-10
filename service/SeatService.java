package service;

import pojo.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> getAllSeats();

    void startMeal(int seatNumber);

    void endMeal(int seatNumber);
}
