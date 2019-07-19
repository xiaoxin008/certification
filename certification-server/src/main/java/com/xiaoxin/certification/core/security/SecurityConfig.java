package com.xiaoxin.certification.core.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * SpringSecurity基础配置
 *
 * @author xiaoxin008(313595055 @ qq.com)
 * @since 1.0.0
 */
@EnableWebSecurity
@Configuration
@Order(2)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        HttpSecurity security = http.requestMatchers()
                .antMatchers("/login")
                .antMatchers("/oauth/**")
                .antMatchers("/account/**")
                .antMatchers("/auth/**")
                .antMatchers("/connect/**")
                .antMatchers("/signup")
                .antMatchers("/register")
                .and()
                .authorizeRequests()
                .antMatchers("/account/**").hasRole("ADMIN")
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/connect/**").permitAll()
                .antMatchers("/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and().csrf().disable();
        security.apply(new SpringSocialConfigurer());
    }

}
