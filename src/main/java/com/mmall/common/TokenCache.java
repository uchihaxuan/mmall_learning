package com.mmall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class TokenCache {
    private static org.slf4j.Logger Logger = LoggerFactory.getLogger(TokenCache.class);
    public static final String TOKEN_PREFIX = "token_";

    private static LoadingCache<String, String> loaclCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS)
            .build(new CacheLoader<String, String>() {
                //默认数据加载实现，当调用get取值时候，如果key没有对应的值，就调用这个方法进行加载
                @Override
                public String load(String s) throws Exception {
                    return "null";
                }
            });

    public static void setKey(String key, String value) {
        loaclCache.put(key, value);
    }

    public static String getKey(String key) {
        String value = null;
        try {
            value = loaclCache.get(key);
            if ("null".equals(value)) {
                return null;
            }
            return value;
        } catch (Exception e) {
            Logger.error("localCache get error",e);
        }
        return null;
    }
}
