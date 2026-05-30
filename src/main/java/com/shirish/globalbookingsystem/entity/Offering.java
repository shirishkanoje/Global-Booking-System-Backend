package com.shirish.globalbookingsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "offerings")
public class Offering extends BaseEntity {

    @Column(nullable = false)
    private String batchName;

    @JsonIgnoreProperties({
            "hibernateLazyInitializer",
            "handler",
            "offerings"
    })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @JsonIgnoreProperties({
            "hibernateLazyInitializer",
            "handler",
            "offerings"
    })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @JsonIgnoreProperties({
            "hibernateLazyInitializer",
            "handler",
            "offering"
    })
    @OneToMany(
            mappedBy = "offering",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Session> sessions = new ArrayList<>();

    @JsonIgnoreProperties({
            "hibernateLazyInitializer",
            "handler"
    })
    @OneToMany(mappedBy = "offering")
    private List<Booking> bookings = new ArrayList<>();
}