package com.xiaoxin008.client.security;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全初始化配置
 *
 * @author xiaoxin008(313595055 @ qq.com)
 * @since 1.0.0
 */
@Order(2)
@EnableOAuth2Sso
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers("/login**","/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable().cors();
    }
}
