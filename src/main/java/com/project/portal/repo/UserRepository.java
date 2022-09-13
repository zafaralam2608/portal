package com.project.portal.repo;

import com.project.portal.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Gets a user by user name.
     *
     * @param username the user name of the requested user
     * @return the user
     */
    User findByUsername(String username);

    /**
     * Gets a user by email.
     *
     * @param email the email of the requested user
     * @return the user
     */
    User findByEmail(String email);
}
