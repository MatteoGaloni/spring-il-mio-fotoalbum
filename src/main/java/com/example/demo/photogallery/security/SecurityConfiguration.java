package com.example.demo.photogallery.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public DatabaseUserDetailsService userDetailsService() {
        return new DatabaseUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests()
                .requestMatchers("/photos/delete/**").hasAnyAuthority("ADMIN")
                .requestMatchers("/photos/edit/**").hasAnyAuthority("ADMIN")
                .requestMatchers("/photos/update/visibility").hasAnyAuthority("SUPERADMIN")
                .requestMatchers("/photos/update/**").hasAnyAuthority("ADMIN")
                .requestMatchers("/photos/create").hasAnyAuthority("ADMIN")
                .requestMatchers("/photos", "/photos/**").hasAnyAuthority("ADMIN", "SUPERADMIN")
                .requestMatchers("/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .logout();
        http.csrf().disable();
        return http.build();
    }

}