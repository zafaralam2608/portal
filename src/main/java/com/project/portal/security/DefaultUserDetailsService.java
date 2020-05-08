package com.project.portal.security;

import com.project.portal.model.Privilege;
import com.project.portal.model.Role;
import com.project.portal.model.User;
import com.project.portal.repo.PrivilegeRepository;
import com.project.portal.repo.RoleRepository;
import com.project.portal.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DefaultUserDetailsService implements UserDetailsService {

    final UserRepository userRepository;

    final RoleRepository roleRepository;

    final PrivilegeRepository privilegeRepository;

    @PostConstruct
    private void init(){
        Privilege privilege;
        Role role;
        List<Privilege> list = new ArrayList<>();
        if(privilegeRepository.findByName("READ")==null) {
            privilege = new Privilege("READ");
            privilegeRepository.save(privilege);
            list.add(privilege);
        }
        if(roleRepository.findByName("ROLE_USER")==null) {
            role= new Role("ROLE_USER");
            role.setPrivileges(list);
            roleRepository.save(role);
        }
        if(privilegeRepository.findByName("WRITE")==null) {
            privilege = new Privilege("WRITE");
            privilegeRepository.save(privilege);
            list.add(privilege);
        }
        if(privilegeRepository.findByName("ROLE_ADMIN")==null) {
            role = new Role("ROLE_ADMIN");
            role.setPrivileges(list);
            roleRepository.save(role);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user  = userRepository.findByUsername(username);
        if (null == user)
            throw new UsernameNotFoundException("No user exists with username " + username);
        return new Principal(user);
    }

}
