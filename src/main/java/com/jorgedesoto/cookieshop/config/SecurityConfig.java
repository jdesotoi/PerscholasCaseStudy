package com.jorgedesoto.cookieshop.config;

import com.jorgedesoto.cookieshop.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailService userDetailService;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(auth ->
                        auth.mvcMatchers("/", "/shop", "subscription", "/static/**","/css/**", "/js/**","/img/**")
                                .permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .permitAll()
                        .passwordParameter("password")
                        .usernameParameter("email"))
                .userDetailsService(userDetailService)
                .build();
    }
//    @Bean
//    CommandLineRunner commandLineRunner (){
//
//    }
}
