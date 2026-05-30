package com.shirish.globalbookingsystem.dto.request.booking;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookOfferingRequest {

    @NotNull(message = "Parent id is required")
    private Long parentId;

    @NotNull(message = "Offering id is required")
    private Long offeringId;
}