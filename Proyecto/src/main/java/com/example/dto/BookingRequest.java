package com.example.dto;

import com.example.model.PassengerInfo;
import com.example.model.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookingRequest {
    private PaymentInfo paymentInfo;
    private PassengerInfo passengerInfo;
}
