package com.jshin.jeonse.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Configuration
@EnableWebSecurity //SpringSecurityFilterChain 포함
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 시큐리티 설정
    * @param http the {@link HttpSecurity} to modify
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers( "/js/**", "/css/**", "img/**", "vendor/*").permitAll(); //모든 접근허용
        http.authorizeRequests().antMatchers("/auth/login").permitAll(); // 로그인 페이지 접근 허용
        http.authorizeRequests().anyRequest().hasRole("USER");
        http.formLogin().loginPage("/auth/login").defaultSuccessUrl("/");

        //로그아웃
//        http.logout().logoutUrl("/auth/user/logout").invalidateHttpSession(true).logoutSuccessUrl("/auth/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("testUser1")
                .password(passwordEncoder().encode("test123!")).roles("USER")
                .and()
                .withUser("testUser2")
                .password(passwordEncoder().encode("test123!")).roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
