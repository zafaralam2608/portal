package com.project.portal.config;

import com.project.portal.security.DefaultUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /** The dependency for PasswordEncoder. */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /** The dependency for UserDetailsService. */
    @Autowired
    private DefaultUserDetailsService userDetailsService;

    /**
     * The method to configure application authentication.
     *
     * @param auth the authentication object
     */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder);
    }

    /**
     * The method to configure application security.
     *
     * @param http the http object
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/portal", "/register").permitAll()
                .antMatchers("/*").authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/home");
    }

    /**
     * The method to configure web security.
     *
     * @param web the web object
     */
    @Override
    public void configure(final WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }
}
