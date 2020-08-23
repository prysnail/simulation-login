package com.prysnail.simulation.login.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 * @author prysnail
 * @date 2020/8/23 20:44
 */
@Data
public class User {

    private Long id;
    //用户名
    private String loginName;

    private String email;

    private Long organizationId;

    private String language;

    private String timeZone;

    private Integer isEnabled;
}
