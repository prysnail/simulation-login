package com.prysnail.simulation.login.infra.factory;

import com.prysnail.simulation.login.api.service.IUserNameAcquire;
import com.prysnail.simulation.login.api.service.impl.EnvUser;
import com.prysnail.simulation.login.api.service.impl.FileUser;
import com.prysnail.simulation.login.api.service.impl.PropertyUser;

/**
 * 用户名获取 工厂
 * @author prysnail
 * @date 2020/8/23 17:43
 */
public class UserNameAcquireFactory {
    //策略
    private UserNameStrategy strategy;

    public UserNameAcquireFactory(UserNameStrategy strategy){
        this.strategy = strategy;
    }

    /**
     * 创建用户名获取 具体实例
     * @return
     */
    public IUserNameAcquire create(){
        IUserNameAcquire service = null;
        switch (this.strategy){
            case ENV:
                service = new EnvUser();
                break;
            case FILE:
                service = new FileUser();
                break;
            case PROPERTY:
                service = new PropertyUser();
                break;
        }
        return service;
    }
}
