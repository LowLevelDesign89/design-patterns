package com.app.blockingQueue;

import com.app.blockingQueue.consumer.Consumer;
import com.app.blockingQueue.producer.Producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Client {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(5);

        for(int i = 0; i < 2; i++) {
            Producer producer = new Producer(blockingQueue);
            Thread t1 = new Thread(producer);
            t1.start();
        }

        for(int i = 0; i < 3; i++) {
            Consumer consumer = new Consumer(blockingQueue);
            Thread t2 = new Thread(consumer);
            t2.start();
        }
    }
}
