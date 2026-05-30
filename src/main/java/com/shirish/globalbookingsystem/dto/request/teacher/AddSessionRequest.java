package com.shirish.globalbookingsystem.dto.request.teacher;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddSessionRequest {

    @NotNull(message = "Offering id is required")
    private Long offeringId;

    @NotNull(message = "Start time is required")
    private String startTime;

    @NotNull(message = "End time is required")
    private String endTime;
}