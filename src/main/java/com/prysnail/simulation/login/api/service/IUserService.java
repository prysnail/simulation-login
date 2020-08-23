package com.prysnail.simulation.login.api.service;

import com.prysnail.simulation.login.domain.entity.User;

import java.io.IOException;

/**
 * 用户service
 * @author prysnail
 * @date 2020/8/23 23:10
 */
public interface IUserService {
    /**
     * 获取用户信息
     * @return
     */
    User getUserInfo() throws IOException;
}
