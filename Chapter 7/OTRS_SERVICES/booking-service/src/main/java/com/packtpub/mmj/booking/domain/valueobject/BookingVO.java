package com.packtpub.mmj.booking.domain.valueobject;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingVO {

    private String name;
    private String id;
    private String restaurantId;
    private String userId;
    private LocalDate date;

    private LocalTime time;
    private String tableId;

    public BookingVO(String id, String name, String restaurantId, String tableId, String userId, LocalDate date, LocalTime time) {
        this.id = id;
        this.name = name;
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.date = date;
        this.time = time;
    }
}