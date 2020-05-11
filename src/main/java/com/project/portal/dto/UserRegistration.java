package com.project.portal.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UserRegistration {

    @NonNull
    private String username;

    @NonNull
    private String firstName;

    private String lastName;

    @NonNull
    private String password;

    private String matchPassword;

    @NotBlank
    @Email
    private String email;
}
