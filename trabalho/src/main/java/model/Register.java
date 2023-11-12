package model;

import java.util.Date;

public interface Register {
    void registerCheckOut(Date checkOutDate);
    void registerCheckIn(Date checkInDate);
}

