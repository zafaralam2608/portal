package com.project.portal.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Privilege {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}
