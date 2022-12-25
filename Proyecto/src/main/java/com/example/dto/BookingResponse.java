package com.example.dto;

import com.example.model.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookingResponse {
    private String status;
    private double totalFare;
    private String pnr;
    private PassengerInfo passengerInfo;
}
