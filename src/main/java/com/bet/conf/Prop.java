package com.bet.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by pwy on 16/5/3.
 */
@Component
public class Prop {

    @Value("${redis.host}")
    public String redisHost;
    @Value("${redis.port}")
    public Integer redisPort;

}
