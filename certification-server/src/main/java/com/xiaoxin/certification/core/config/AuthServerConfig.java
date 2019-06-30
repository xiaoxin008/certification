package com.xiaoxin.certification.core.config;

import com.xiaoxin.certification.core.security.AuthRedisTokenStore;
import com.xiaoxin.certification.util.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * 授权服务器配置类
 *
 * @author xiaoxin008(313595055 @ qq.com)
 * @since 1.0.0
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private MyPasswordEncoder myPasswordEncoder;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;  // redis连接工厂

    /**
     * 令牌存储
     * @return redis令牌存储对象
     */
    @Bean
    public TokenStore tokenStore() {
        return new AuthRedisTokenStore(redisConnectionFactory);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client") // clientId, 可以类比为用户名
                .secret(myPasswordEncoder.encode("123456")) // secret， 可以类比为密码
                .authorizedGrantTypes("authorization_code")    // 授权类型，这里选择授权码
                .scopes("user_info") // 授权范围
                .autoApprove(true) // 自动认证
                .redirectUris("http://localhost:8882/client/login","http://localhost:8883/client/login")    // 认证成功重定向URL
                .accessTokenValiditySeconds(1000); // 超时时间，10s
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        //允许表单认证
        oauthServer.allowFormAuthenticationForClients();
    }

}
