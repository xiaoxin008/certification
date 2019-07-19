package com.xiaoxin.certification.domain;

import lombok.*;

import java.util.List;

/**
 * 账户实体
 *
 * @author xiaoxin008(313595055 @ qq.com)
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor //必须要有无参构造器
@RequiredArgsConstructor
@ToString
//@Accessors(chain = true)
public class Account {

    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    private List<Role> roles;
}
