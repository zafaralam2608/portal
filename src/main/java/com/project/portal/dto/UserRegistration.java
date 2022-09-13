package com.project.portal.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UserRegistration {

    /** The name of user. */
    @NonNull
    private String username;

    /** The first name of user. */
    @NonNull
    private String firstName;

    /** The last name of user. */
    private String lastName;

    /** The password of user. */
    @NonNull
    private String password;

    /** The confirmation of password of user. */
    private String matchPassword;

    /** The main id of user. */
    @NotBlank
    @Email
    private String email;
}
