package com.example.demo_hw4.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
public class SecurityConfig {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("12345678").roles("NOT_All");
    }

    protected void configure(HttpSecurity http) throws Exception {
        // http.authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin();
                http
                .authorizeRequests().antMatchers("/persons/by-city").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin();
    }
}
