package model;

import java.time.LocalDate;

public interface Register {
    void registerCheckOut(LocalDate checkOutDate);
    void registerCheckIn(LocalDate checkInDate);
}

