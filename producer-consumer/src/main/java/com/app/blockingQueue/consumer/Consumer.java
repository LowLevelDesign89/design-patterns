package com.app.blockingQueue.consumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                String message = blockingQueue.take();
                System.out.println("Consumed message : " + message);
            } catch (InterruptedException e) {
                System.err.println("An error occurred while trying to consume message");
                break;
            }
        }
    }
}
