package com.prysnail.simulation.login.infra.factory;

/**
 * 用户名策略 枚举类
 * @author prysnail
 * @date 2020/8/23 18:02
 */
public enum UserNameStrategy {
    /**
     * 获取策略-环境变量
     */
    ENV ,
    /**
     * 获取策略-用户名配置文件
     */
    FILE ,
    /**
     * 获取策略-属性
     */
    PROPERTY
}
