package com.app.ratelimiter.strategies.impl;

import com.app.ratelimiter.strategies.RateLimiterStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FixedWindowRateLimiter implements RateLimiterStrategy {
    private Map<Long, Map<String, Integer>> usageMap;
    private int maxTPS;
    private Lock lock;

    private final int THOUSAND = 1000;
    private final int MODULO_SECOND = 86400;

    public FixedWindowRateLimiter(int maxTPS) {
        this.maxTPS = maxTPS;
        this.lock = new ReentrantLock();
        usageMap = new HashMap<>();
    }

    @Override
    public boolean shouldAllow(String userId) {
        if(maxTPS <= 0)
            return false;
        lock.lock();
        long bucketNumber = getCurrentBucket();
        if(!usageMap.containsKey(bucketNumber)) {
            usageMap.clear();
            usageMap.put(bucketNumber, new HashMap<>());
        }
        Map<String, Integer> currentBucketUsageMap = usageMap.get(bucketNumber);
        if(!currentBucketUsageMap.containsKey(userId)) {
            currentBucketUsageMap.put(userId, 1);
            usageMap.put(bucketNumber, currentBucketUsageMap);
            lock.unlock();
            return true;
        } else {
            if(currentBucketUsageMap.get(userId) >= maxTPS) {
                lock.unlock();
                return false;
            }
            currentBucketUsageMap.put(userId, currentBucketUsageMap.getOrDefault(userId, 0) + 1);
            usageMap.put(bucketNumber, currentBucketUsageMap);
            lock.unlock();
            return true;
        }
    }

    private long getCurrentBucket() {
        long currentSecond = System.currentTimeMillis() / THOUSAND;
        return (currentSecond % MODULO_SECOND);
    }
}
