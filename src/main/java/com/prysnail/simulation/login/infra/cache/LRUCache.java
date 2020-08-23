package com.prysnail.simulation.login.infra.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存
 * @author prysnail
 * @date 2020/8/23 22:59
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    //缓存容量
    private int cacheSize;

    //默认负载因子
    private static final float DEFAULT_FACTOR = 0.75f;

    public LRUCache(int capacity , int cacheSize){
        super(capacity , DEFAULT_FACTOR , true);
        this.cacheSize = cacheSize;
    }

    public LRUCache(int capacity , float loadFactor , int cacheSize){
        super(capacity , loadFactor , true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        //删除超过缓存容量时，删除最老元素
        return size() > this.cacheSize;
    }
}
