package com.example.TKPM_Project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Tắt CSRF bảo vệ
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll()  // Cho phép tất cả các yêu cầu mà không cần xác thực
                );

        return http.build();
    }
}
