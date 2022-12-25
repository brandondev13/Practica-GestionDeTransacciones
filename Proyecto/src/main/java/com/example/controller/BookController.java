package com.example.controller;

import com.example.dto.BookingRequest;
import com.example.dto.BookingResponse;
import com.example.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public BookingResponse bookTicket(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookTicket(bookingRequest);
    }
}
