package com.eva.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by 01348085 on 2017/7/10.
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60 * 60)
public class SessionConfig {
}
