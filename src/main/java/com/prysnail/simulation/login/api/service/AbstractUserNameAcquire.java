package com.prysnail.simulation.login.api.service;

import com.prysnail.simulation.login.infra.UserConstant;

import java.io.IOException;

/**
 * 用户名获取抽象类
 * @author prysnail
 * @date 2020/8/23 14:44
 */
public abstract class AbstractUserNameAcquire implements IUserNameAcquire {
    /**
     * 默认用户名
     * @return
     */
    public String defaultUserName(){
        return UserConstant.DEFAULT_USER_NAME;
    }
}
