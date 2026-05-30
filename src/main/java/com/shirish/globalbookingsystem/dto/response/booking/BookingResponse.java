package com.shirish.globalbookingsystem.dto.response.booking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponse {

    private Long bookingId;

    private String parentName;

    private String offeringName;

    private String bookingStatus;
}