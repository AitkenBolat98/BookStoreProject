package com.example.BookStoreProject.configuration;

import com.example.BookStoreProject.constants.Roles;
import com.example.BookStoreProject.filter.CsrfCookieFilter;
import com.example.BookStoreProject.filter.JWTTokenGeneratorFilter;
import com.example.BookStoreProject.filter.JWTTokenValidatorFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

import static com.example.BookStoreProject.constants.Permissions.*;
import static com.example.BookStoreProject.constants.Roles.ADMIN;
import static com.example.BookStoreProject.constants.Roles.MANAGER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class BookStoreSecurityConfig {
    @Autowired
    private ProjectAuthenticationProvider authenticationProvider;

    private final JWTTokenGeneratorFilter jwtTokenGeneratorFilter;

    private final LogoutHandler logoutHandler;
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf((csrf)->csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(HttpMethod.POST,"/api/v1/auth/**" )
                        .permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/v1/csrf")
                        .permitAll()
                        .requestMatchers("/api/v1/management/**").hasAnyRole(ADMIN.name(), MANAGER.name())

                        .requestMatchers(HttpMethod.GET,"/api/v1/management/**")
                        .hasAnyAuthority(ADMIN_READ.name(),MANAGER_READ.name())
                        .requestMatchers(HttpMethod.POST,"/api/v1/management/**")
                        .hasAnyAuthority(ADMIN_CREATE.name(),MANAGER_CREATE.name())
                        .requestMatchers(HttpMethod.DELETE,"/api/v1/management/**")
                        .hasAnyAuthority(ADMIN_DELETE.name(),MANAGER_DELETE.name())
                        .requestMatchers(HttpMethod.PUT,"/api/v1/management/**")
                        .hasAnyAuthority(ADMIN_UPDATE.name(),MANAGER_UPDATE.name())

                        .requestMatchers("/api/v1/admin/**").hasRole(ADMIN.name())

                        .requestMatchers(HttpMethod.GET,"/api/v1/admin/**")
                        .hasAuthority(ADMIN_READ.name())
                        .requestMatchers(HttpMethod.POST,"/api/v1/admin/**")
                        .hasAuthority(ADMIN_CREATE.name())
                        .requestMatchers(HttpMethod.DELETE,"/api/v1/admin/**")
                        .hasAuthority(ADMIN_DELETE.name())
                        .requestMatchers(HttpMethod.PUT,"/api/v1/admin/**")
                        .hasAuthority(ADMIN_UPDATE.name())

                        .anyRequest()
                        .authenticated()
                ).sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtTokenGeneratorFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(l->l.logoutUrl("/api/v1/auth/logout")
                        .addLogoutHandler(logoutHandler).logoutSuccessHandler((request, response, authentication) ->
                        SecurityContextHolder.clearContext()));
    return http.build();
    }
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder
                = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
        return authenticationManagerBuilder.build();
    }

}
