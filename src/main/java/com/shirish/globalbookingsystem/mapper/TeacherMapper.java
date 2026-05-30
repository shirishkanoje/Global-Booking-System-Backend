package com.shirish.globalbookingsystem.mapper;

import com.shirish.globalbookingsystem.dto.response.teacher.TeacherResponse;
import com.shirish.globalbookingsystem.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public TeacherResponse mapToResponse(Teacher teacher) {

        TeacherResponse response = new TeacherResponse();

        response.setId(teacher.getId());
        response.setName(teacher.getName());
        response.setEmail(teacher.getEmail());
        response.setTimezone(teacher.getTimezone());

        return response;
    }
}