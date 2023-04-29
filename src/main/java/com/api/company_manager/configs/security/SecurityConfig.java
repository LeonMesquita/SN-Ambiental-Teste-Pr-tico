package com.api.company_manager.configs.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import lombok.RequiredArgsConstructor;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    static final String BASE_URL = "/api/";

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic(withDefaults())
        .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(HttpMethod.GET, BASE_URL).permitAll()
                        .requestMatchers(HttpMethod.POST, BASE_URL).hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, BASE_URL).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, BASE_URL).hasRole("ADMIN")
                        .anyRequest().authenticated());

        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
