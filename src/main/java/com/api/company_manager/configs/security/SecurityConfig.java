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
    static final String BASE_PATH = "/api/address/";

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic(withDefaults())
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, BASE_PATH).permitAll()
                .requestMatchers(HttpMethod.POST, BASE_PATH).hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, BASE_PATH).hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, BASE_PATH).hasRole("ADMIN")
        .anyRequest().authenticated();

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
