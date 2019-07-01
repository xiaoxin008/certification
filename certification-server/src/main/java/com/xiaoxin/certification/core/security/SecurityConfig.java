package com.xiaoxin.certification.core.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
        http.requestMatchers()
                .antMatchers("/login")
                .antMatchers("/oauth/**")
                .antMatchers("/account/**")
                .and()
                .authorizeRequests()
                .antMatchers("/account/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and().csrf().disable();
    }

}
