package com.xiaoxin.certification.core.social;

import com.xiaoxin.certification.domain.Account;
import com.xiaoxin.certification.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 * 注册页面
 *
 * @author xiaoxin008(313595055 @ qq.com)
 * @since 1.0.0
 */
@Controller
public class SignUpController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    private Environment environment;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value="/signup", method= RequestMethod.GET)
    public String signup(WebRequest request) {
        //创建账号
        return "register";
    }

    @RequestMapping(value="/signup", method= RequestMethod.POST)
    public String signupForm(String phone,String password, WebRequest request) {
        //创建账号
        Account account = accountService.getAccountByUsername(phone);
        if(account == null){
            Account a = new Account(phone,password);
            accountService.insertAccount(a);
        }
        providerSignInUtils.doPostSignUp(phone,request);
        return "redirect:".concat(environment.getProperty("github.auth-url"));
    }

}
