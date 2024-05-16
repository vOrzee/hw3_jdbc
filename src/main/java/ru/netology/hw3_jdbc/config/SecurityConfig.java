package ru.netology.hw3_jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(withDefaults())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/persons/by-city").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

        UserDetails ivan = User.builder()
                .username("Ivan").password(passwordEncoder.encode("pass")).roles("READ")
                .build();

        UserDetails sergey = User.builder()
                .username("Sergey").password(passwordEncoder.encode("pass")).roles("WRITE")
                .build();

        UserDetails vasiliy = User.builder()
                .username("Vasiliy").password(passwordEncoder.encode("pass")).roles("DELETE")
                .build();

        UserDetails roman = User.builder()
                .username("Roman").password(passwordEncoder.encode("pass")).roles("READ", "WRITE", "DELETE")
                .build();

        return new InMemoryUserDetailsManager(ivan, sergey, vasiliy, roman);
    }
}
