package com.shirish.globalbookingsystem.service.impl;

import com.shirish.globalbookingsystem.dto.request.teacher.AddSessionRequest;
import com.shirish.globalbookingsystem.dto.request.teacher.CreateCourseRequest;
import com.shirish.globalbookingsystem.dto.request.teacher.CreateOfferingRequest;
import com.shirish.globalbookingsystem.dto.request.teacher.CreateTeacherRequest;
import com.shirish.globalbookingsystem.entity.Course;
import com.shirish.globalbookingsystem.entity.Offering;
import com.shirish.globalbookingsystem.entity.Session;
import com.shirish.globalbookingsystem.entity.Teacher;
import com.shirish.globalbookingsystem.exception.OfferingNotFoundException;
import com.shirish.globalbookingsystem.exception.TeacherNotFoundException;
import com.shirish.globalbookingsystem.repository.CourseRepository;
import com.shirish.globalbookingsystem.repository.OfferingRepository;
import com.shirish.globalbookingsystem.repository.SessionRepository;
import com.shirish.globalbookingsystem.repository.TeacherRepository;
import com.shirish.globalbookingsystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final OfferingRepository offeringRepository;
    private final SessionRepository sessionRepository;

    @Override
    public Teacher createTeacher(CreateTeacherRequest request) {

        Teacher teacher = new Teacher();

        teacher.setName(request.getName());
        teacher.setEmail(request.getEmail());
        teacher.setTimezone(request.getTimezone());

        return teacherRepository.save(teacher);
    }

    @Override
    public Course createCourse(CreateCourseRequest request) {

        Course course = new Course();

        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());

        return courseRepository.save(course);
    }

    @Override
    public Offering createOffering(CreateOfferingRequest request) {

        Teacher teacher = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() ->
                        new TeacherNotFoundException("Teacher not found")
                );

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() ->
                        new RuntimeException("Course not found")
                );

        Offering offering = new Offering();

        offering.setBatchName(request.getBatchName());
        offering.setTeacher(teacher);
        offering.setCourse(course);

        return offeringRepository.save(offering);
    }

    @Override
    public Session addSession(AddSessionRequest request) {

        Offering offering = offeringRepository.findById(request.getOfferingId())
                .orElseThrow(() ->
                        new OfferingNotFoundException("Offering not found")
                );

        Session session = new Session();

        session.setOffering(offering);

        session.setStartTime(
                Instant.parse(request.getStartTime())
        );

        session.setEndTime(
                Instant.parse(request.getEndTime())
        );

        return sessionRepository.save(session);
    }

    @Override
    public List<Offering> getTeacherOfferings(Long teacherId) {

        return offeringRepository.findByTeacherId(teacherId);
    }
}