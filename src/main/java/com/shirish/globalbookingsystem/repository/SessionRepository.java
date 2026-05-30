package com.shirish.globalbookingsystem.repository;

import com.shirish.globalbookingsystem.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findByOfferingId(Long offeringId);

}