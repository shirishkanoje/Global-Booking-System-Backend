package com.shirish.globalbookingsystem.service.impl;

import com.shirish.globalbookingsystem.dto.request.parent.CreateParentRequest;
import com.shirish.globalbookingsystem.entity.Booking;
import com.shirish.globalbookingsystem.entity.Offering;
import com.shirish.globalbookingsystem.entity.Parent;
import com.shirish.globalbookingsystem.exception.ParentNotFoundException;
import com.shirish.globalbookingsystem.repository.BookingRepository;
import com.shirish.globalbookingsystem.repository.OfferingRepository;
import com.shirish.globalbookingsystem.repository.ParentRepository;
import com.shirish.globalbookingsystem.service.ParentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;
    private final OfferingRepository offeringRepository;
    private final BookingRepository bookingRepository;

    @Override
    public Parent createParent(CreateParentRequest request) {

        Parent parent = new Parent();

        parent.setName(request.getName());
        parent.setEmail(request.getEmail());
        parent.setTimezone(request.getTimezone());

        return parentRepository.save(parent);
    }

    @Override
    @Transactional
    public List<Offering> getAvailableOfferings() {

        List<Offering> offerings =
                offeringRepository.findAll();

        offerings.forEach(offering -> {

            offering.getTeacher().getName();

            offering.getCourse().getTitle();

            offering.getSessions().size();
        });

        return offerings;
    }

    @Override
    public List<Booking> getParentBookings(Long parentId) {

        parentRepository.findById(parentId)
                .orElseThrow(() ->
                        new ParentNotFoundException(
                                "Parent not found"
                        )
                );

        return bookingRepository.findByParentId(
                parentId
        );
    }
}