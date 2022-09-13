package com.project.portal.repo;

import com.project.portal.model.Privilege;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    /**
     * Gets a privilege by name.
     *
     * @param name the name of the requested privilege
     * @return the privilege
     */
    Privilege findByName(String name);
}
