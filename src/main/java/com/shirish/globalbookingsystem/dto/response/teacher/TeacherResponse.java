package com.shirish.globalbookingsystem.dto.response.teacher;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherResponse {

    private Long id;

    private String name;

    private String email;

    private String timezone;
}