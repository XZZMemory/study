package com.memory.study.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
//import redis.clients.jedis.JedisPool;

/**
 * created by memory
 * on 2019/8/27 16 22
 */
public class JedisAdapter implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(JedisAdapter.class);

    @Override
    public void afterPropertiesSet() throws Exception {

    }
/*
    private JedisPool jedis;

    @Override
    public void afterPropertiesSet() throws Exception {
        jedis = new JedisPool("redis://localhost:6379");
    }*/
}
