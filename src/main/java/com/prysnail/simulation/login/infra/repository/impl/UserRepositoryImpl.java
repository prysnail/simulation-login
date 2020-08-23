package com.prysnail.simulation.login.infra.repository.impl;

import com.prysnail.simulation.login.domain.entity.User;
import com.prysnail.simulation.login.domain.repository.UserRepository;
import com.prysnail.simulation.login.infra.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author prysnail
 * @date 2020/8/23 21:08
 */
@Component
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String loginName) {
        return userMapper.getUserByName(loginName);
    }
}
