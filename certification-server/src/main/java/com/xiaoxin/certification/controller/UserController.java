package com.xiaoxin.certification.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.social.security.SocialAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * 用户控制器
 *
 * @author xiaoxin008(313595055 @ qq.com)
 * @since 1.0.0
 */
@Controller
public class UserController {

    /**
     * 资源服务器提供的受保护接口
     * @param principal
     * @return
     */
    @RequestMapping("/user")
    @ResponseBody
    public Principal user(Principal principal) {
        OAuth2Authentication authentication = (OAuth2Authentication) principal;
        Authentication userAuthentication = authentication.getUserAuthentication();
        if(userAuthentication instanceof SocialAuthenticationToken){
            principal = new UsernamePasswordAuthenticationToken(
                    userAuthentication.getPrincipal(),userAuthentication.getCredentials(),userAuthentication.getAuthorities());
        }
        System.out.println(principal);
        return principal;
    }
}
