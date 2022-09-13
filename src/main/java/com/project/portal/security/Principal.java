package com.project.portal.security;

import com.project.portal.model.Privilege;
import com.project.portal.model.Role;
import com.project.portal.model.User;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@RequiredArgsConstructor
public class Principal implements UserDetails {

    /** The unique serial  id. */
    private static final long serialVersionUID = 1L;

    /** The wrapped user object. */
    private final transient User user;

    /**
     * Creates a list of authorities.
     *
     * @return the authorities list
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        Collection<Role> roles = user.getRoles();
        for (Role role : roles) {
            Collection<Privilege> privileges = role.getPrivileges();
            for (Privilege privilege : privileges) {
                authorityList.add(
                        new SimpleGrantedAuthority(privilege.getName()));
            }
        }
        return authorityList;
    }

    /**
     * Retrieves the user password.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Retrieves the user name.
     *
     * @return the user name
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * Checks if account is expired.
     *
     * @return the password
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Checks if account is not locked.
     *
     * @return the password
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Checks if credentials are not expired.
     *
     * @return the password
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Checks if account is enabled.
     *
     * @return the password
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
