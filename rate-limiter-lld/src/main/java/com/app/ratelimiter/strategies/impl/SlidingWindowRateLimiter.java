package com.app.ratelimiter.strategies.impl;

import com.app.ratelimiter.strategies.RateLimiterStrategy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SlidingWindowRateLimiter implements RateLimiterStrategy {
    private final int maxTPS;
    private final long windowSizeInSeconds;

    private final int THOUSAND = 1000;

    private Map<String, Deque<Long>> usageMap;


    private Lock lock;

    public SlidingWindowRateLimiter(int maxTPS, long windowSizeInSeconds) {
        this.maxTPS = maxTPS;
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.usageMap = new HashMap<>();
        this.lock = new ReentrantLock();
    }

    @Override
    public boolean shouldAllow(String userId) {
        lock.lock();
        if(!usageMap.containsKey(userId)) {
            usageMap.put(userId, new LinkedList<>());
        }
        long currentTimeInSecond = System.currentTimeMillis() / THOUSAND;
        Deque<Long> deque = usageMap.get(userId);

        while(!deque.isEmpty() && deque.peek() < (currentTimeInSecond - windowSizeInSeconds)) {
            deque.poll();
        }
        if(!deque.isEmpty() && deque.size() >= maxTPS) {
            usageMap.put(userId, deque);
            lock.unlock();
            return false;
        }
        deque.addLast(currentTimeInSecond);
        usageMap.put(userId, deque);
        lock.unlock();
        return false;
    }
}
