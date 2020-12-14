package dao;

import pojo.Reserve;

import java.util.List;

public interface ReserveDao {
    List<Integer> getVacantSeat(int month, int day, int type);

    void createReservation(String account, int month, int day, int type, int seatNumber);

    List<Reserve> getAllReserves();

    List<Reserve> getReservesByDate(int month, int day);

    void deleteReserve(int month, int day, int type, int seatNumber);
}
