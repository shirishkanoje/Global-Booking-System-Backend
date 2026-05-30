package com.shirish.globalbookingsystem.dto.request.teacher;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOfferingRequest {

    @NotBlank(message = "Batch name is required")
    private String batchName;

    @NotNull(message = "Teacher id is required")
    private Long teacherId;

    @NotNull(message = "Course id is required")
    private Long courseId;
}