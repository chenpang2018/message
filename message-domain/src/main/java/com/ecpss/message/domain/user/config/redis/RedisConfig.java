package com.ecpss.message.domain.user.config.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by chenpang on 2018/2/8.
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
@PropertySource(value = "file:/web/profile/boot/redis-connect.properties")
public class RedisConfig {
    private String nodes;
    private String timeout;
    private String maxattempt;
    private String minidle;
    private String maxidle;
    private String maxactive;
    private String maxwait;


    public String getNodes() {
        return nodes;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getMaxattempt() {
        return maxattempt;
    }

    public void setMaxattempt(String maxattempt) {
        this.maxattempt = maxattempt;
    }

    public String getMinidle() {
        return minidle;
    }

    public void setMinidle(String minidle) {
        this.minidle = minidle;
    }

    public String getMaxidle() {
        return maxidle;
    }

    public void setMaxidle(String maxidle) {
        this.maxidle = maxidle;
    }

    public String getMaxactive() {
        return maxactive;
    }

    public void setMaxactive(String maxactive) {
        this.maxactive = maxactive;
    }

    public String getMaxwait() {
        return maxwait;
    }

    public void setMaxwait(String maxwait) {
        this.maxwait = maxwait;
    }
}
