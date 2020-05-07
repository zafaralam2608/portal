package com.project.portal.repo;

import com.project.portal.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    User findByEmail(String email);
}
