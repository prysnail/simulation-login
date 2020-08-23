package com.prysnail.simulation.login.api.service.impl;

import com.prysnail.simulation.login.api.service.IUserNameAcquire;
import com.prysnail.simulation.login.api.service.IUserService;
import com.prysnail.simulation.login.domain.entity.User;
import com.prysnail.simulation.login.domain.repository.UserRepository;
import com.prysnail.simulation.login.infra.cache.LRUCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

/**
 * 用户service实现类
 * @author prysnail
 * @date 2020/8/23 23:12
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    @Qualifier("simulationUserNameService")
    private IUserNameAcquire nameAcquire;
    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    //初始化缓存，线程不安全
    private LRUCache<String , User> lruCache = new LRUCache(16 , 10);

    @Override
    public User getUserInfo() throws IOException {
        //获取用户名
        String loginName = nameAcquire.acquireUserName();

        //先查询缓存
        User user = lruCache.get(loginName);
        if (Objects.nonNull(user)){
            return user;
        }
        //缓存未命中，查询数据库并存入缓存
        user = userRepository.getUserByName(loginName);
        lruCache.put(loginName , user);

        return user;
    }
}
