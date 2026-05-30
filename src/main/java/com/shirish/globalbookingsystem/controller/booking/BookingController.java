package com.shirish.globalbookingsystem.controller.booking;

import com.shirish.globalbookingsystem.dto.request.booking.BookOfferingRequest;
import com.shirish.globalbookingsystem.entity.Booking;
import com.shirish.globalbookingsystem.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking bookOffering(
            @Valid @RequestBody
            BookOfferingRequest request
    ) {

        return bookingService.bookOffering(request);
    }
}