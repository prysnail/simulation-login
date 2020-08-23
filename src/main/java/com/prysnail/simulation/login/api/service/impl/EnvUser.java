package com.prysnail.simulation.login.api.service.impl;

import com.prysnail.simulation.login.api.service.AbstractUserNameAcquire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * 环境变量用户类
 * @author prysnail
 * @date 2020/8/23 11:36
 */
public class EnvUser extends AbstractUserNameAcquire {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnvUser.class);

    @Value("${com.xhb.login.name}")
    private String userName;

    /**
     * 从环境变量中获取用户名，不能动态加载
     * @return
     * @throws IOException
     */
    @Override
    public String acquireUserName() throws IOException {
        LOGGER.info("环境变量中获取用户名：{}" , userName);
        return StringUtils.isEmpty(this.userName) ? super.defaultUserName() : this.userName;
    }
}
