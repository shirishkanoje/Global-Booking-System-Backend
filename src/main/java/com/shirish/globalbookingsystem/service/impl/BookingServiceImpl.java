package com.shirish.globalbookingsystem.service.impl;

import com.shirish.globalbookingsystem.dto.request.booking.BookOfferingRequest;
import com.shirish.globalbookingsystem.entity.Booking;
import com.shirish.globalbookingsystem.entity.Offering;
import com.shirish.globalbookingsystem.entity.Parent;
import com.shirish.globalbookingsystem.entity.Session;
import com.shirish.globalbookingsystem.exception.BookingConflictException;
import com.shirish.globalbookingsystem.exception.ConcurrentBookingException;
import com.shirish.globalbookingsystem.exception.OfferingNotFoundException;
import com.shirish.globalbookingsystem.exception.ParentNotFoundException;
import com.shirish.globalbookingsystem.repository.BookingRepository;
import com.shirish.globalbookingsystem.repository.OfferingRepository;
import com.shirish.globalbookingsystem.repository.ParentRepository;
import com.shirish.globalbookingsystem.service.BookingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ParentRepository parentRepository;
    private final OfferingRepository offeringRepository;

    @Override
    @Transactional
    public Booking bookOffering(BookOfferingRequest request) {

        try {

            Parent parent = parentRepository.findById(request.getParentId())
                    .orElseThrow(() ->
                            new ParentNotFoundException("Parent not found")
                    );

            Offering offering = offeringRepository.findById(request.getOfferingId())
                    .orElseThrow(() ->
                            new OfferingNotFoundException("Offering not found")
                    );

            List<Session> sessions = offering.getSessions();

            for (Session session : sessions) {

                List<Booking> conflicts =
                        bookingRepository.findConflictingBookings(
                                parent.getId(),
                                session.getStartTime(),
                                session.getEndTime()
                        );

                if (!conflicts.isEmpty()) {
                    throw new BookingConflictException(
                            "Booking conflict detected for session timing"
                    );
                }
            }

            Booking booking = new Booking();

            booking.setParent(parent);
            booking.setOffering(offering);

            return bookingRepository.save(booking);

        } catch (CannotAcquireLockException ex) {

            throw new ConcurrentBookingException(
                    "Concurrent booking detected. Please retry."
            );
        }
    }
}