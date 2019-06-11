package com.xiaoxin.certification.domain;

import lombok.*;

/**
 * 角色实体
 *
 * @author xiaoxin008(313595055 @ qq.com)
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor //必须要有无参构造器
@AllArgsConstructor
@ToString
public class Role {

    private Long id;

    private String name;

    private String expression;

    private String description;
}
