package com.xiaoxin.certification.service;

import com.xiaoxin.certification.domain.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * 账户服务
 *
 * @author xiaoxin008(313595055 @ qq.com)
 * @since 1.0.0
 */
public interface AccountService extends UserDetailsService {

    List<Account> listAccount();
}
