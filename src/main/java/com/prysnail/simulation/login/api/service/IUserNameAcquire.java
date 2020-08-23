package com.prysnail.simulation.login.api.service;

import java.io.IOException;

/**
 * 用户名获取接口
 * @author prysnail
 * @date 2020/8/23 11:12
 */
public interface IUserNameAcquire {
    /**
     * 获取用户名
     * @return 用户名
     * @throws IOException
     */
    String acquireUserName() throws IOException;
}
