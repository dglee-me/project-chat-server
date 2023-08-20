package kr.co.ds.chat.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private JwtTokenGenerator jwtTokenGenerator;

    public JwtSecurityConfig(JwtTokenGenerator tokenProvider) {
        this.jwtTokenGenerator = tokenProvider;
    }

    @Override
    public void configure(HttpSecurity http) {
        http.addFilterBefore(
                new JwtFilter(jwtTokenGenerator),
                UsernamePasswordAuthenticationFilter.class
        );
    }
}