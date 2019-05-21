package com.ecpss.message.controller.user;

import com.ecpss.message.infrastructure.redis.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;

/**
 * Created by chenpang on 2018/2/8.
 */
@Controller
@RequestMapping(value = "redis")
public class RedisController {
//    @Resource
//    private JedisCluster jedisCluster;
//
//    @RequestMapping(value = "redisWelcome", produces = "text/html")
//    @ResponseBody
//    public String redisWelcome() {
//
//        String s = jedisCluster.get("hellp");
//        return s;
//    }

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping(value = "redisWelcome", produces = "text/html")
    @ResponseBody
    public String redisWelcome(String name) {

        String s = redisUtil.getKey(name);
        return s;
    }
}
