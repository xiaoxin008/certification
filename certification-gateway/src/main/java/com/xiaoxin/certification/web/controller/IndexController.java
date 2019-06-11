package com.xiaoxin.certification.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页控制器
 *
 * @author xiaoxin008(313595055 @ qq.com)
 * @since 1.0.0
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
