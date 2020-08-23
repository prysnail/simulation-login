package com.prysnail.simulation.login.domain.repository;

import com.prysnail.simulation.login.domain.entity.User;

/**
 * 用户仓库
 * @author prysnail
 * @date 2020/8/23 21:06
 */
public interface UserRepository {
    /**
     * 通过用户名获取用户
     * @param loginName
     * @return
     */
    User getUserByName(String loginName);
}
