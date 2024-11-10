package com.example.LLD.RateLimit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.HostAndPort;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisClusterBean {

    @Value("${redis.cluster.nodes}")
    private String clusterNodes;

    @Value("${redis.cluster.timeout}")
    private int timeout;

    @Bean
    public JedisCluster jedisCluster() {
        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
        String[] nodes = clusterNodes.split(",");
        for (String node : nodes) {
            String[] hostPort = node.split(":");
            jedisClusterNodes.add(new HostAndPort(hostPort[0], Integer.parseInt(hostPort[1])));
        }

        return new JedisCluster(jedisClusterNodes, timeout);
    }
}