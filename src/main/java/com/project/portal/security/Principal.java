package com.project.portal.security;

import com.project.portal.model.Privilege;
import com.project.portal.model.Role;
import com.project.portal.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Principal implements UserDetails {

    private final User user;

    public Principal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        Collection<Role> roles = user.getRoles();
        for (Role role : roles) {
            Collection<Privilege> privileges = role.getPrivileges();
            for (Privilege privilege : privileges)
                authorityList.add(new SimpleGrantedAuthority(privilege.getName()));
        }
        return authorityList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
