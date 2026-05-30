package com.shirish.globalbookingsystem.controller.parent;

import com.shirish.globalbookingsystem.dto.request.parent.CreateParentRequest;
import com.shirish.globalbookingsystem.dto.response.teacher.OfferingResponse;
import com.shirish.globalbookingsystem.entity.Booking;
import com.shirish.globalbookingsystem.entity.Offering;
import com.shirish.globalbookingsystem.entity.Parent;
import com.shirish.globalbookingsystem.mapper.OfferingMapper;
import com.shirish.globalbookingsystem.service.ParentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parents")
@RequiredArgsConstructor
public class ParentController {

    private final ParentService parentService;
    private final OfferingMapper offeringMapper;

    @PostMapping
    public Parent createParent(
            @Valid @RequestBody
            CreateParentRequest request
    ) {

        return parentService.createParent(request);
    }

    @GetMapping("/offerings")
    public List<OfferingResponse> getAvailableOfferings() {

        List<Offering> offerings =
                parentService.getAvailableOfferings();

        return offerings.stream()
                .map(offeringMapper::mapToResponse)
                .toList();
    }

    @GetMapping("/{parentId}/bookings")
    public List<Booking> getParentBookings(
            @PathVariable Long parentId
    ) {

        return parentService.getParentBookings(
                parentId
        );
    }
}