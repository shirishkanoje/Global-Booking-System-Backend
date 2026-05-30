package com.shirish.globalbookingsystem.service;

import com.shirish.globalbookingsystem.dto.request.teacher.AddSessionRequest;
import com.shirish.globalbookingsystem.dto.request.teacher.CreateCourseRequest;
import com.shirish.globalbookingsystem.dto.request.teacher.CreateOfferingRequest;
import com.shirish.globalbookingsystem.dto.request.teacher.CreateTeacherRequest;
import com.shirish.globalbookingsystem.entity.Course;
import com.shirish.globalbookingsystem.entity.Offering;
import com.shirish.globalbookingsystem.entity.Session;
import com.shirish.globalbookingsystem.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher createTeacher(CreateTeacherRequest request);

    Course createCourse(CreateCourseRequest request);

    Offering createOffering(CreateOfferingRequest request);

    Session addSession(AddSessionRequest request);

    List<Offering> getTeacherOfferings(Long teacherId);
}