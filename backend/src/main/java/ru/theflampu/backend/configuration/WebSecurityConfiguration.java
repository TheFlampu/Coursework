package ru.theflampu.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import ru.theflampu.backend.security.JWTAuthenticationFilter;
import ru.theflampu.backend.security.JWTLoginFilter;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeRequests()
                .antMatchers("/api/register").not().authenticated()
                .antMatchers("/api/getTest", "/api/getTests", "/api/solve/*", "/api/categories", "/api/getAuthorities", "/api/profile")
                .hasAuthority("ROLE_USER")
                .antMatchers("/api/create", "/api/edit", "/api/delete/*", "/api/createdTest")
                .hasAuthority("ROLE_CREATOR")
                .antMatchers("/api/panel/users", "/api/panel/roles", "/api/panel/deleteUser/*", "/api/panel/editUser")
                .hasAuthority("ROLE_ADMIN")
                .anyRequest().permitAll()
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .deleteCookies("COOKIE-BEARER")
                .logoutSuccessUrl("/")
                .and()
                .addFilterBefore(new JWTLoginFilter("/api/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
