package com.project.portal.model;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Role {

    /** The unique id. */
    @Id
    @GeneratedValue
    private Long id;

    /** The roll name. */
    @NonNull
    private String name;

    /** The linked users. */
    @ToString.Exclude
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    /** The linked privileges. */
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ROLE_PRIVILEGE",
        joinColumns = @JoinColumn(
                name = "ROLE_ID", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
                name = "PRIVILEGE_ID", referencedColumnName = "id")
    )
    private Collection<Privilege> privileges;

}
