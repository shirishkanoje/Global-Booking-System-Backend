package com.shirish.globalbookingsystem.repository;

import com.shirish.globalbookingsystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}