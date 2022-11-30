package com.seproject.projectmilestone3.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("admin").password("admin").roles("ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("ADMIN")
                .antMatchers("/patients").hasRole("ADMIN")
                .antMatchers("/savePatient").hasRole("ADMIN")
                .antMatchers("/persistPatient").hasRole("ADMIN")
                .antMatchers("/updatePatient/**").hasRole("ADMIN")
                .antMatchers("/doctors").hasRole("ADMIN")
                .antMatchers("/saveDoctor").hasRole("ADMIN")
                .antMatchers("/persistDoctor").hasRole("ADMIN")
                .antMatchers("/updateDoctor/**").hasRole("ADMIN")
                .and().formLogin().permitAll();

    }
}
