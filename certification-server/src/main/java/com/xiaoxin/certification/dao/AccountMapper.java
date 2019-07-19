package com.xiaoxin.certification.dao;

import com.xiaoxin.certification.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 账户dao
 *
 * @author xiaoxin008(313595055 @ qq.com)
 * @since 1.0.0
 */
@Mapper
public interface AccountMapper {

    /**
     * 根据账户用户名查询账户对象
     *
     * @param username 账户用户名
     * @return 账户对象
     */
    Account getAccountByUsername(@Param("username") String username);

    /**
     * 获取账户集合
     *
     * @return 账户集合对象
     */
    List<Account> geteAccountList();

    /**
     * 添加账户
     * @param account
     * @return
     */
    int insertAccount(Account account);
}
