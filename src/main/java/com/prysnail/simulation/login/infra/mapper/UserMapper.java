package com.prysnail.simulation.login.infra.mapper;

import com.prysnail.simulation.login.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 用户mapper
 * @author prysnail
 * @date 2020/8/23 20:37
 */
public interface UserMapper {
    /**
     * 通过获取用户
     * @param loginName 用户名
     * @return
     */
    @Select("select * from iam_user where login_name=#{loginName} and is_enabled =1")
    User getUserByName(@Param("loginName")String loginName);
}
