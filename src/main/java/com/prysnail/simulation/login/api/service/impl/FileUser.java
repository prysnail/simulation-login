package com.prysnail.simulation.login.api.service.impl;

import com.prysnail.simulation.login.api.service.AbstractUserNameAcquire;
import com.prysnail.simulation.login.infra.constant.ComConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件用户类
 * @author prysnail
 * @date 2020/8/23 11:25
 */
public class FileUser extends AbstractUserNameAcquire {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUser.class);

    @Value("${com.xhb.login.filePath:}")
    private String filePath;

    /**
     * 从文件中获取用户名
     * @return 用户名
     * @throws IOException
     */
    @Override
    public String acquireUserName() throws IOException {
        String path = StringUtils.isEmpty(filePath) ? ComConstant.DEFAULT_USER_FILE_PATH : filePath;
        LOGGER.info("用户文件路径：{}" , path);
        BufferedReader in = new BufferedReader(new FileReader(path));
        String userName = in.readLine();
        LOGGER.info("用户文件中获取到用户名：{}" , userName);
        return StringUtils.isEmpty(userName) ? super.defaultUserName() : userName;
    }
}
