package org.example.lab_3_oauth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //HTTP Security Configuration
        return http
                .authorizeHttpRequests( auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.anyRequest().authenticated();
                }  )

                //OAuth2 Login and Form Login
                .oauth2Login(withDefaults())
                .formLogin(withDefaults())

                // Logout Configuration
                .logout(logout -> logout.logoutSuccessUrl("https://github.com/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))

                //Building the Configuration
                .build();
    }
}