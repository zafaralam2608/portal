package com.project.portal.dto.user;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class UserRegistration {

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
