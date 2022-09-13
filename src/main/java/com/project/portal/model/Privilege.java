package com.project.portal.model;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Privilege {

    /** The unique id. */
    @Id
    @GeneratedValue
    private Long id;

    /** The privilege name. */
    @NonNull
    private String name;

    /** The linked roles. */
    @ToString.Exclude
    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}
