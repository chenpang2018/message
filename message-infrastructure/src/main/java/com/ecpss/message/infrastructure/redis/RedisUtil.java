package com.ecpss.message.infrastructure.redis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * Created by chenpang on 2019/5/20 16:26.
 */
@Component
public class RedisUtil {

    public String getKey(String key) {
        Jedis jedis = JedisClusterUtil.getJedis();
        String s = jedis.get(key);
        JedisClusterUtil.closeJedis(jedis);
        return s;
    }
}
