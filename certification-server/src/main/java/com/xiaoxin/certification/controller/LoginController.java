package com.xiaoxin.certification.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 登录控制器
 *
 * @author xiaoxin008(313595055 @ qq.com)
 * @since 1.0.0
 */
@Controller
public class LoginController {

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
