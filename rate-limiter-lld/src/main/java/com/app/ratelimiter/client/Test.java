package com.app.ratelimiter.client;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 20; i++) {
            long currentTs = System.currentTimeMillis() / 1000;

            System.out.println(currentTs);

            System.out.println("Modulo 86400: " + currentTs % 86400);
            Thread.sleep(500);
        }
    }
}
