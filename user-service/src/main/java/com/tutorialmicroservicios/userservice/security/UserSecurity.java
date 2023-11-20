package com.tutorialmicroservicios.userservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserSecurity{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> authz
                .anyRequest().authenticated()
        );
        http.oauth2ResourceServer((oauth2) -> oauth2
                .jwt(Customizer.withDefaults())
        );
        return http.build();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests().anyRequest().authenticated()
//                .and()
//                .oauth2ResourceServer().jwt();
//    }
}
