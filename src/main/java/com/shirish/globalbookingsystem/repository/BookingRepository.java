package com.shirish.globalbookingsystem.repository;

import com.shirish.globalbookingsystem.entity.Booking;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByParentId(Long parentId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
            SELECT b
            FROM Booking b
            JOIN b.offering o
            JOIN o.sessions s
            WHERE b.parent.id = :parentId
            AND b.status = 'BOOKED'
            AND (
                    s.startTime < :endTime
                    AND s.endTime > :startTime
                )
            """)
    List<Booking> findConflictingBookings(
            Long parentId,
            Instant startTime,
            Instant endTime
    );
}