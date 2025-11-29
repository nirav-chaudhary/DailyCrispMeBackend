package com.example.dailycrispme.config;

import com.example.dailycrispme.entity.UserEntity;
import com.example.dailycrispme.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.time.LocalDateTime;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/me").authenticated()
                        .anyRequest().permitAll())
                .oauth2Login(oauth2 -> oauth2
                        .successHandler(successHandler()));

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return (request, response, authentication) -> {
            OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
            String email = oauth2User.getAttribute("email");
            String name = oauth2User.getAttribute("name");
            String picture = oauth2User.getAttribute("picture");
            String providerId = oauth2User.getAttribute("sub"); // Google ID

            UserEntity user = userRepository.findByEmail(email)
                    .orElse(new UserEntity());

            if (user.getId() == null) {
                user.setCreatedAt(LocalDateTime.now());
                user.setProvider("google");
                user.setProviderId(providerId);
            }

            user.setEmail(email);
            user.setName(name);
            user.setPictureUrl(picture);
            user.setLastLogin(LocalDateTime.now());

            userRepository.save(user);

            // Redirect to frontend
            String frontendUrl = System.getenv("FRONTEND_URL");
            if (frontendUrl == null) {
                frontendUrl = "http://localhost:3000";
            }
            response.sendRedirect(frontendUrl);
        };
    }
}
