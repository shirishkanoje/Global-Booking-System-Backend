package com.shirish.globalbookingsystem.dto.response.parent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentResponse {

    private Long id;

    private String name;

    private String email;

    private String timezone;
}