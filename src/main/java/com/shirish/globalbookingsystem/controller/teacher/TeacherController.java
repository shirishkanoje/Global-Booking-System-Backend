package com.shirish.globalbookingsystem.controller.teacher;

import com.shirish.globalbookingsystem.dto.request.teacher.AddSessionRequest;
import com.shirish.globalbookingsystem.dto.request.teacher.CreateCourseRequest;
import com.shirish.globalbookingsystem.dto.request.teacher.CreateOfferingRequest;
import com.shirish.globalbookingsystem.dto.request.teacher.CreateTeacherRequest;
import com.shirish.globalbookingsystem.entity.Course;
import com.shirish.globalbookingsystem.entity.Offering;
import com.shirish.globalbookingsystem.entity.Session;
import com.shirish.globalbookingsystem.entity.Teacher;
import com.shirish.globalbookingsystem.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public Teacher createTeacher(
            @Valid @RequestBody
            CreateTeacherRequest request
    ) {

        return teacherService.createTeacher(request);
    }

    @PostMapping("/courses")
    public Course createCourse(
            @Valid @RequestBody
            CreateCourseRequest request
    ) {

        return teacherService.createCourse(request);
    }

    @PostMapping("/offerings")
    public Offering createOffering(
            @Valid @RequestBody
            CreateOfferingRequest request
    ) {

        return teacherService.createOffering(request);
    }

    @PostMapping("/sessions")
    public Session addSession(
            @Valid @RequestBody
            AddSessionRequest request
    ) {

        return teacherService.addSession(request);
    }

    @GetMapping("/{teacherId}/offerings")
    public List<Offering> getTeacherOfferings(
            @PathVariable Long teacherId
    ) {

        return teacherService.getTeacherOfferings(
                teacherId
        );
    }
}