package com.shirish.globalbookingsystem.mapper;

import com.shirish.globalbookingsystem.dto.response.booking.BookingResponse;
import com.shirish.globalbookingsystem.entity.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingResponse mapToResponse(Booking booking) {

        BookingResponse response = new BookingResponse();

        response.setBookingId(booking.getId());

        response.setParentName(
                booking.getParent().getName()
        );

        response.setOfferingName(
                booking.getOffering().getBatchName()
        );

        response.setBookingStatus(
                booking.getStatus().name()
        );

        return response;
    }
}