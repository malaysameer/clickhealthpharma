package com.clickhealth.pharma.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        JwtAuthFilter jwtFilter = new JwtAuthFilter(jwtTokenProvider);

        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()

                // Public endpoints
                .requestMatchers("/auth/login","/suppliers/**","/purchases/**","/users/**","/sales/**","/reports/**","/customers/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
/*

                // Medicines
                .requestMatchers(HttpMethod.GET, "/medicines/**").hasAnyRole("PHARMACIST", "MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/medicines/**").hasAnyRole("PHARMACIST", "MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.PUT, "/medicines/**").hasAnyRole("PHARMACIST", "MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/medicines/**").hasRole("ADMIN") // deletion restricted to ADMIN

                // Customers
                .requestMatchers(HttpMethod.GET, "/customers/**").hasAnyRole("CASHIER", "MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/customers/**").hasAnyRole("CASHIER", "MANAGER", "ADMIN")

                // Reports
                .requestMatchers(HttpMethod.GET, "/reports/**").hasAnyRole("MANAGER", "ADMIN")
*/

                // Catch all other routes
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
