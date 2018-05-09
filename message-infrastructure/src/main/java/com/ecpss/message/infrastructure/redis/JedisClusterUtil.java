package com.ecpss.message.infrastructure.redis;

import com.ecpss.message.domain.user.config.redis.RedisConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenpang on 2018/2/8.
 */
@Configuration
public class JedisClusterUtil {
    @Resource
    private RedisConfig redisConfig;

    @Bean
    public JedisCluster getJedisCluster() {
        //ip端口解析
        String nodes = redisConfig.getNodes();
        String[] node = nodes.split(",");
        Set<HostAndPort> set = new HashSet<>();
        for (String s : node) {
            String[] hostAndPort = s.split(":");
            HostAndPort port = new HostAndPort(hostAndPort[0].trim(), Integer.parseInt(hostAndPort[1].trim()));
            set.add(port);
        }
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(redisConfig.getMaxactive() == null ? JedisPoolConfig.DEFAULT_MAX_TOTAL : Integer.parseInt(redisConfig.getMaxactive()));
        poolConfig.setMaxWaitMillis(redisConfig.getMaxwait() == null ? JedisPoolConfig.DEFAULT_MAX_WAIT_MILLIS : Long.parseLong(redisConfig.getMaxactive()));
        poolConfig.setMinIdle(redisConfig.getMinidle() == null ? JedisPoolConfig.DEFAULT_MIN_IDLE : Integer.parseInt(redisConfig.getMinidle()));
        poolConfig.setMaxIdle(redisConfig.getMaxidle() == null ? JedisPoolConfig.DEFAULT_MAX_IDLE : Integer.parseInt(redisConfig.getMaxidle()));

        JedisCluster jedisCluster = new JedisCluster(set, Integer.parseInt(redisConfig.getTimeout()),
                Integer.parseInt(redisConfig.getMaxattempt()), poolConfig);

        return jedisCluster;
    }
}
