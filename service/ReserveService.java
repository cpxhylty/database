package service;

import java.util.List;

public interface ReserveService {
    List<Integer> getVacantSeat(int month, int day, int type);

    void createReservation(String account, int month, int day, int type, int seatNumber);
}
