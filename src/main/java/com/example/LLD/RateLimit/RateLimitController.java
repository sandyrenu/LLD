package com.example.LLD.RateLimit;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.LLD.RateLimit.RedisConfiguration;
@RestController
public class RateLimitController {
    @Autowired
    RedisConfiguration redisConfiguration;

    @Autowired
    RateLimitService rateLimitService;
    @Operation(summary = "Test Rate Limit", description = "Testing rate limit functionality")
    @GetMapping("/testingRateLimit")
    public String rateLimitRedis(@RequestParam (value = "userId") String userId){
        System.out.println("get api called");
        boolean isAllowed = true;
        isAllowed = redisConfiguration.isAllowed(userId);
        System.out.println(isAllowed);
        if(!isAllowed){
            return "exceeded the RateLimit";
        }
        return userId;
    }
    @GetMapping("/testingRateLimitCluster")
    public String rateLimitRedisCluster(@RequestParam(value = "userId") String userId) {
        System.out.println("Get API called");

        // Check if the user is allowed to make the request
        boolean isAllowed = rateLimitService.isAllowed(userId);

        if (!isAllowed) {
            return "Exceeded the rate limit";
        }

        return "Request allowed for user: " + userId;
    }

}
