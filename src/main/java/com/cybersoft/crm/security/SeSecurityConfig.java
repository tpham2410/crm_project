package com.cybersoft.crm.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SeSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        /*
           antMatchers: định nghĩa link cần xác thực
           authenticated: bắc buộc chứng thực đăng nhập
           permitAll: cho phép full quyền đăng nhập vào link chỉ định ở antMachers
           anyRequest: toàn bộ gọi vào API
         */

        httpSecurity.csrf().disable().authorizeRequests().anyRequest().permitAll();


        //Add filter A trước cái gì đó
        //httpSecurity.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();

    }
}
