package com.prysnail.simulation.login.api.service.impl;

import com.prysnail.simulation.login.api.service.AbstractUserNameAcquire;
import com.prysnail.simulation.login.infra.ComConstant;
import com.prysnail.simulation.login.infra.UserConstant;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * 属性用户类
 * @author prysnail
 * @date 2020/8/23 11:26
 */
public class PropertyUser extends AbstractUserNameAcquire {
    @Override
    public String acquireUserName() throws IOException {
        //可实现动态加载配置文件，读取最新的配置信息
        Properties properties = new Properties();
        InputStream in = PropertyUser.class.getClassLoader().getResourceAsStream("application.properties");
        properties.load(in);
        String propertyKey = properties.stringPropertyNames().stream()
                .filter(ComConstant.USER_NAME_PROPERTY::equals)
                .findFirst()
                .get();
        return StringUtils.isEmpty(propertyKey) ? super.defaultUserName() : properties.getProperty(propertyKey);
    }
}
