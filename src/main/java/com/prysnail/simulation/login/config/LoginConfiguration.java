package com.prysnail.simulation.login.config;

import com.prysnail.simulation.login.api.service.IUserNameAcquire;
import com.prysnail.simulation.login.api.service.impl.EnvUser;
import com.prysnail.simulation.login.infra.factory.UserNameAcquireFactory;
import com.prysnail.simulation.login.infra.factory.UserNameStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * @author prysnail
 * @date 2020/8/23 17:22
 */
@ConditionalOnProperty(
        prefix = "com.xhb.login",
        value = "enable",
        havingValue = "true"
)
@Configuration
public class LoginConfiguration {

    //用户名获取策略
    @Value("${com.xhb.login.strategy:env}")
    private String strategy;

    //防止与应用bean重名
    @Bean(name = "simulationUserNameService")
    public IUserNameAcquire userNameAcquire(){
        UserNameStrategy enumStrategy = UserNameStrategy.valueOf(strategy.toUpperCase());
        return new UserNameAcquireFactory(enumStrategy).create();
    }

}
