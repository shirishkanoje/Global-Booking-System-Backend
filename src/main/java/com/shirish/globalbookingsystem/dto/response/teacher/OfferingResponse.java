package com.shirish.globalbookingsystem.dto.response.teacher;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OfferingResponse {

    private Long id;

    private String batchName;

    private String teacherName;

    private String courseTitle;

    private List<SessionResponse> sessions;
}