package com.shirish.globalbookingsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shirish.globalbookingsystem.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String timezone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.TEACHER;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<Offering> offerings = new ArrayList<>();
}