package com.app.ratelimiter.strategies.impl;

import com.app.ratelimiter.strategies.RateLimiterStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TokenBucketRateLimiter implements RateLimiterStrategy {
    private final int maxTPS;
    private long lastRefillTimeStamp;
    private final int refillPerSecond;

    private Map<String, Integer> usageMap;

    private Lock lock;
    private final int THOUSAND = 1000;

    public TokenBucketRateLimiter(int maxTPS, int refillPerSecond) {
        this.maxTPS = maxTPS;
        this.lastRefillTimeStamp = System.currentTimeMillis() / THOUSAND;
        this.refillPerSecond = refillPerSecond;
        this.usageMap = new HashMap<>();
        this.lock = new ReentrantLock();
    }

    @Override
    public boolean shouldAllow(String userId) {
        lock.lock();
        refillToken(userId);

        if(usageMap.get(userId) == 0) {
            lock.unlock();
            return false;
        }
        usageMap.put(userId, usageMap.get(userId) - 1);
        lock.unlock();

        return true;
    }

    private void refillToken(String userId) {
        int availableToken = usageMap.getOrDefault(userId, 0);
        long currentTimeInSecond = System.currentTimeMillis() / THOUSAND;
        long timeElapsed = currentTimeInSecond - lastRefillTimeStamp;
        availableToken += (int) (timeElapsed * refillPerSecond);
        availableToken = Integer.min(availableToken, maxTPS);
        usageMap.put(userId, availableToken);
    }
}
