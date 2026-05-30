package com.shirish.globalbookingsystem.service;

import com.shirish.globalbookingsystem.dto.request.booking.BookOfferingRequest;
import com.shirish.globalbookingsystem.entity.Booking;

public interface BookingService {

    Booking bookOffering(BookOfferingRequest request);
}