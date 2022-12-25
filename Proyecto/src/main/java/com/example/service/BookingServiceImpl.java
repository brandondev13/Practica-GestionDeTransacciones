package com.example.service;

import com.example.dto.BookingRequest;
import com.example.dto.BookingResponse;
import com.example.exception.InsufficientBalanceException;
import com.example.model.PassengerInfo;
import com.example.model.PaymentInfo;
import com.example.repository.PassengerInfoRepository;
import com.example.repository.PaymentInfoRepository;
import com.example.utility.PaymentGatewaySimulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    public BookingResponse bookingResponse;

    @Transactional(readOnly = false, rollbackFor = {InsufficientBalanceException.class, Exception.class}, isolation = Isolation.READ_COMMITTED)
    public BookingResponse bookTicket(BookingRequest bookingRequest) {
        BookingResponse bookingResponse = null;
        PassengerInfo passengerInfo = passengerInfoRepository.save(bookingRequest.getPassengerInfo());
        PaymentInfo paymentInfo = bookingRequest.getPaymentInfo();
        PaymentGatewaySimulator.validateFareBalanceCriteria(paymentInfo.getAccountNo(), passengerInfo.getFare());
        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setTotalFare(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        bookingResponse = new BookingResponse();
        bookingResponse.setStatus("SUCCESS");
        bookingResponse.setPnr(UUID.randomUUID().toString().split("-")[0]);
        bookingResponse.setPassengerInfo(passengerInfo);
        bookingResponse.setTotalFare(passengerInfo.getFare());
        return bookingResponse;
    }
}