package com.example.productdevelopment.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] UN_SECURED_URLs = {
            "/",
            "/users/**",
            "/login/**",
            "/register",
            "/logout",
            "/contact",
            "/about",
            "/css/**",
            "/js/**",
            "/gameNews",
            "/live",
            "/liveVideo",
            "/footballLive",
            "/gameSchedule",
            "/gameSchedule/**",
            "/images/**",
            "/comment/**",
            "/video/**",
            "/resources/**",
            "/webjars/**", "/assets/**"
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsServices();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((auth) -> auth.requestMatchers(UN_SECURED_URLs).permitAll())
                .authorizeHttpRequests((auth) -> auth.requestMatchers("/admin/**").authenticated())
                .authorizeHttpRequests((auth) -> auth.requestMatchers("/user/**").hasRole("USER"))
                //.authorizeHttpRequests((auth) -> auth.anyRequest().authenticated())
                 .authorizeHttpRequests((auth) -> auth.anyRequest().permitAll())
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                //.formLogin((login) -> login.loginPage("/login").permitAll())
                .logout((logout) -> logout.logoutUrl("/logout")
                        .logoutSuccessUrl("/"))
                .exceptionHandling(exc -> exc.accessDeniedPage("/403"));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
