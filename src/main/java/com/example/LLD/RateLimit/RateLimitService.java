package com.example.LLD.RateLimit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service
public class RateLimitService {

    private final JedisCluster jedisCluster;

    @Autowired
    public RateLimitService(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

    public boolean isAllowed(String userId) {
        String key = "rate_limit:" + userId;

        // Set the rate limit to 100 requests per minute
        int rateLimit = 100;
        int expirationTime = 120;  // Expiration time in seconds (1 minute)

        // Increment the count in Redis
        Long currentCount = jedisCluster.incr(key);

        // If the count is 1, set an expiration time (first request)
        if (currentCount == 1) {
            jedisCluster.expire(key, expirationTime);
        }

        // If the count exceeds the rate limit, deny the request
        return currentCount <= rateLimit;
    }
}
