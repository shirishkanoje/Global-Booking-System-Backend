package com.shirish.globalbookingsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String title;

    @Column(length = 1000)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Offering> offerings = new ArrayList<>();
}