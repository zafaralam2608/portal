package com.project.portal.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String createdDate;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name="USER_ID",referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="ROLE_ID",referencedColumnName="id")
    )
    private Collection<Role> roles;
}
