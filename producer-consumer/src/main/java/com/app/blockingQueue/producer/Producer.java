package com.app.blockingQueue.producer;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = new LinkedBlockingQueue<>();
    }

    @Override
    public void run() {
        while(true) {
            String uuid = UUID.randomUUID().toString();
            try {
                blockingQueue.put(uuid);
            } catch (InterruptedException e) {
                System.err.println("Error occurred while trying to put items in the queue");
                break;
            }
        }
    }
}
