package com.app.ratelimiter.strategies;

public interface RateLimiterStrategy {
    boolean shouldAllow(String userId);
}
