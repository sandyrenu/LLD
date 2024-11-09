package com.example.LLD.RateLimit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
@Configuration
public class RedisConfiguration {
    private final Jedis jedis;
    private final int requestsPerMinute;


    public RedisConfiguration(@Value("${redis.host}") String host,
                              @Value("${redis.port}") int port,
                              @Value("${redis.requestsPerMinute}") int requestsPerMinute){
        this.jedis = new Jedis(host, port);
        this.requestsPerMinute = requestsPerMinute;
    }
    public boolean isAllowed(String userId) {
        String key = "rate_limiter:" + userId;
        long currentCount = jedis.incr(key);
        System.out.println(currentCount);
        // Check if it's the first request in the period
        if (currentCount == 1) {
            jedis.expire(key, 120);  // Set expiration time for the key (e.g., 60 seconds for 1 minute)
        }

        // Allow the request if within the limit
        return currentCount <= requestsPerMinute;
    }


}
