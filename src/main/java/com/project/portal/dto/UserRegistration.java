package com.project.portal.dto;


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

    private String middleName;

    @NonNull
    private String lastName;

    @NonNull
    private String password;

    private String matchPassword;

    @NonNull
    private String email;
}
