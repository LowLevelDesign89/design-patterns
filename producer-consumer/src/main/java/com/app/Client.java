package com.app;

import com.app.consumer.Consumer;
import com.app.producer.Producer;
import com.app.sharedresource.DataQueue;

public class Client {
    public static void main(String[] args) {
        DataQueue queue = new DataQueue(4);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();

        //producer.stop();
        //consumer.stop();
    }
}
