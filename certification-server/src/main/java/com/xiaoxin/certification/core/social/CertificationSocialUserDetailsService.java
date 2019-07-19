package com.xiaoxin.certification.core.social;

import com.xiaoxin.certification.domain.Account;
import com.xiaoxin.certification.domain.Role;
import com.xiaoxin.certification.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 获取统一用户
 *
 * @author xiaoxin008(313595055 @ qq.com)
 * @since 1.0.0
 */
@Service
public class CertificationSocialUserDetailsService implements SocialUserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public SocialUserDetails loadUserByUserId(String username) throws UsernameNotFoundException {
        Account account = accountService.getAccountByUsername(username);
        List<Role> roles = account.getRoles();
        List<String> roleNames = roles.stream().map(Role::getExpression).collect(Collectors.toList());
        SocialUser socialUser = new SocialUser(account.getUsername(), account.getPassword(), AuthorityUtils.createAuthorityList(roleNames.toArray(new String[roleNames.size()])));
        return socialUser;
    }
}
