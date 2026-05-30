package com.shirish.globalbookingsystem.dto.request.parent;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateParentRequest {

    @NotBlank(message = "Parent name is required")
    private String name;

    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Timezone is required")
    private String timezone;
}