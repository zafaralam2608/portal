package com.project.portal.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
@NoArgsConstructor
public class User {
    /** The unique id. */
    @Id
    @GeneratedValue
    private Long id;

    /** The name of user. */
    private String username;

    /** The password of user. */
    private String password;

    /** The first name of user. */
    private String firstName;

    /** The last name of user. */
    private String lastName;

    /** The main id of user. */
    private String email;

    /** The time stamp of entity creation. */
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date created;

    /** The time stamp of entity last update. */
    @UpdateTimestamp
    private Date updated;

    /** The linked roles. */
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(
                name = "USER_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                name = "ROLE_ID", referencedColumnName = "id")
    )
    private Collection<Role> roles;
}
