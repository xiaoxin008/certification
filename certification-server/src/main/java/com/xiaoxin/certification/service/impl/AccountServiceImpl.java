package com.xiaoxin.certification.service.impl;

import com.xiaoxin.certification.dao.AccountMapper;
import com.xiaoxin.certification.domain.Account;
import com.xiaoxin.certification.domain.Role;
import com.xiaoxin.certification.service.AccountService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 账户服务实现
 *
 * @author xiaoxin008(313595055 @ qq.com)
 * @since 1.0.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> listAccount() {
        return accountMapper.geteAccountList();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        if(StringUtils.isEmpty(username)){
            throw new IllegalArgumentException("username is null !!!");
        }
        Account account = accountMapper.getAccountByUsername(username);
        if (account == null){
            throw new UsernameNotFoundException("account is not found !!!");
        }
        List<Role> roles = account.getRoles();
        List<String> roleNames = roles.stream().map(Role::getExpression).collect(Collectors.toList());
        userDetails = new User(account.getUsername(),account.getPassword(), AuthorityUtils.createAuthorityList(roleNames.toArray(new String[roleNames.size()])));
        return userDetails;
    }
}
