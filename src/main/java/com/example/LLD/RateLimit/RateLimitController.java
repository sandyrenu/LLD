package com.example.LLD.RateLimit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.LLD.RateLimit.RedisConfiguration;

@RestController
public class RateLimitController {

    @Autowired
    RedisConfiguration redisConfiguration;

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

}
