package com.xiaoxin.certification.controller;

import com.xiaoxin.certification.domain.Account;
import com.xiaoxin.certification.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 账号接口
 *
 * @author xiaoxin008(313595055 @ qq.com)
 * @since 1.0.0
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/account/list")
    public List<Account> list(){
        return accountService.listAccount();
    }
}
