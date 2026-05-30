package com.shirish.globalbookingsystem.dto.request.teacher;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCourseRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;
}