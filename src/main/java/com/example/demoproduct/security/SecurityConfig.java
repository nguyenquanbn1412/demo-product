package com.example.demoproduct.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Cấu hình đường dẫn
        String[] publicRoutes = new String[]{"/css/**", "/js/**", "/images/**"};
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers(publicRoutes).permitAll();
            auth.requestMatchers("/").permitAll();
            auth.requestMatchers(HttpMethod.GET,"/dashboard").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers(HttpMethod.GET,"/users/**").hasRole("ADMIN");
            auth.requestMatchers(HttpMethod.POST,"/users/**").hasRole("ADMIN");
            auth.requestMatchers(HttpMethod.PUT,"/users/**").hasRole("ADMIN");
            auth.requestMatchers("/categories/**").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers("/products/**").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers("/brands/**").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers(HttpMethod.GET,"/orders/**").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers(HttpMethod.POST,"/orders/**").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers(HttpMethod.PUT,"/orders/**").hasAnyRole("ADMIN", "SALE");
            auth.requestMatchers("/posts/**").hasAnyRole("ADMIN", "SALE", "AUTHOR");
            auth.requestMatchers(HttpMethod.GET,"/user-profile").hasRole("USER");
            auth.requestMatchers(HttpMethod.PUT,"/user-profile").hasRole("USER");
            auth.anyRequest().authenticated();
        });

        // Cấu hình form login
        http.formLogin(form -> {
            form.defaultSuccessUrl("/", true);
            form.permitAll();
        });

        // Cấu hình logout
        http.logout(logout -> {
            logout.logoutSuccessUrl("/");
            logout.invalidateHttpSession(true);
            logout.deleteCookies("JSESSIONID");
            logout.clearAuthentication(true);
            logout.permitAll();
        });

        return http.build();
    }
}
