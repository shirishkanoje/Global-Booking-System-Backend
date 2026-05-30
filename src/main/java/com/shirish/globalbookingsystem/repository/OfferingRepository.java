package com.shirish.globalbookingsystem.repository;

import com.shirish.globalbookingsystem.entity.Offering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferingRepository extends JpaRepository<Offering, Long> {

    List<Offering> findByTeacherId(Long teacherId);

}