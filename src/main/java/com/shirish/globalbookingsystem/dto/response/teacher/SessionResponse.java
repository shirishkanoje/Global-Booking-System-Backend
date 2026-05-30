package com.shirish.globalbookingsystem.dto.response.teacher;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionResponse {

    private Long id;

    private String startTime;

    private String endTime;
}