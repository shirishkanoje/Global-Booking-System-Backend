package com.shirish.globalbookingsystem.mapper;

import com.shirish.globalbookingsystem.dto.response.teacher.OfferingResponse;
import com.shirish.globalbookingsystem.dto.response.teacher.SessionResponse;
import com.shirish.globalbookingsystem.entity.Offering;
import com.shirish.globalbookingsystem.entity.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OfferingMapper {

    public OfferingResponse mapToResponse(Offering offering) {

        OfferingResponse response = new OfferingResponse();

        response.setId(offering.getId());
        response.setBatchName(offering.getBatchName());

        response.setTeacherName(
                offering.getTeacher().getName()
        );

        response.setCourseTitle(
                offering.getCourse().getTitle()
        );

        List<SessionResponse> sessionResponses =
                offering.getSessions()
                        .stream()
                        .map(this::mapSession)
                        .toList();

        response.setSessions(sessionResponses);

        return response;
    }

    private SessionResponse mapSession(Session session) {

        SessionResponse response = new SessionResponse();

        response.setId(session.getId());

        response.setStartTime(
                session.getStartTime().toString()
        );

        response.setEndTime(
                session.getEndTime().toString()
        );

        return response;
    }
}