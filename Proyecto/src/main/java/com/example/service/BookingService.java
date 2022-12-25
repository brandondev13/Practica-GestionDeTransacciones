package com.example.service;

import com.example.dto.BookingRequest;
import com.example.dto.BookingResponse;

public interface BookingService {
    public BookingResponse bookTicket(BookingRequest bookingRequest);
}
