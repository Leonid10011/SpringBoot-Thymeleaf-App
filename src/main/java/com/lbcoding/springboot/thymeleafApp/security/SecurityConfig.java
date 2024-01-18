package com.lbcoding.springboot.thymeleafApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        // Spring knows now the datasource details and handles the rest
        // 1. Searching for users in user and authorities tables
        // 2. Retrieving them and check passwords and roles
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        // If custom tables desired, tell spring how to access it
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id,pw, active from members where user_id=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/employees/showFormForUpdate/**").hasRole("MANAGER")
                        .requestMatchers("/employees/showFormForAdd/**").hasRole("MANAGER")
                        .requestMatchers("/employees/delete/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                        .loginPage("/showLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/accessDenied"));;

        return http.build();
    }
}
