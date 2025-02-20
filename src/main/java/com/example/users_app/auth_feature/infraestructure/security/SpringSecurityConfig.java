package com.example.users_app.auth_feature.infraestructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(authz -> authz
                .requestMatchers(HttpMethod.GET,"/user").permitAll()
                .requestMatchers(HttpMethod.GET,"/user/{id}").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.POST,"/user").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT,"/user/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/user/{id}").hasRole("ADMIN")
                .anyRequest().authenticated()
        ).csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}
