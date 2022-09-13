package com.project.portal.repo;

import com.project.portal.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Gets a role by name.
     *
     * @param name the name of the requested role
     * @return the role
     */
    Role findByName(String name);
}
