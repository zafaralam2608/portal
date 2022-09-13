package com.project.portal.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.portal.model.Privilege;
import com.project.portal.model.Role;
import com.project.portal.model.User;
import com.project.portal.repo.PrivilegeRepository;
import com.project.portal.repo.RoleRepository;
import com.project.portal.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultUserDetailsService implements UserDetailsService {

    /** The dependency for user repository. */
    private final UserRepository userRepository;

    /** The dependency for role repository. */
    private final RoleRepository roleRepository;

    /** The dependency for privilege repository. */
    private final PrivilegeRepository privilegeRepository;

    @PostConstruct
    private void init() {
        Privilege privilege;
        Role role;
        List<Privilege> list = new ArrayList<>();
        if (privilegeRepository.findByName("READ") == null) {
            privilege = new Privilege("READ");
            privilegeRepository.save(privilege);
            list.add(privilege);
        }
        if (roleRepository.findByName("ROLE_USER") == null) {
            role = new Role("ROLE_USER");
            role.setPrivileges(list);
            roleRepository.save(role);
        }
        if (privilegeRepository.findByName("WRITE") == null) {
            privilege = new Privilege("WRITE");
            privilegeRepository.save(privilege);
            list.add(privilege);
        }
        if (privilegeRepository.findByName("ROLE_ADMIN") == null) {
            role = new Role("ROLE_ADMIN");
            role.setPrivileges(list);
            roleRepository.save(role);
        }
    }

    /**
     * Loads a user by user name.
     *
     * @param username the user name
     * @return the UserDetails wrapper
     */
    @Override
    public UserDetails loadUserByUsername(final String username) {
        User user  = userRepository.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException(
                    "No user exists with username " + username);
        }
        return new Principal(user);
    }

}
