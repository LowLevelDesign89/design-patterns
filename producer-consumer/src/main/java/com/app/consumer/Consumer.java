package com.app.consumer;

import com.app.sharedresource.DataQueue;
import com.app.sharedresource.Message;

public class Consumer implements Runnable {
    private DataQueue dataQueue;
    private boolean running = false;

    public Consumer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        running = true;
        consumeMessage();
    }

    private void consumeMessage() {
        while(running) {
            if(dataQueue.isEmpty()) {
                try {
                    System.out.println("Queue is empty, nothing to consume");
                    dataQueue.waitOnEmpty();
                } catch (InterruptedException e) {
                    System.err.println("Error occurred while waiting for empty");
                    break;
                }
            }
            if(!running)
                break;
            Message message = dataQueue.remove();
            System.out.println(message.getContent());
        }
    }

    public void stop() {
        running = false;
        dataQueue.notifyOnFull();
    }
}
