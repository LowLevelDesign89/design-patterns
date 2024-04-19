package com.app.producer;

import com.app.sharedresource.DataQueue;
import com.app.sharedresource.Message;

import java.util.UUID;

public class Producer implements Runnable {
    private DataQueue queue;
    private boolean running = false;

    public Producer(DataQueue dataQueue) {
        this.queue = dataQueue;
    }

    @Override
    public void run() {
        running = true;
        produceMessage();
    }

    private void produceMessage() {
        while(running) {
            if(queue.isFull()) {
                try {
                    System.out.println("Queue is Full, Can't produce");
                    queue.waitOnFull();
                } catch (InterruptedException e) {
                    System.err.println("Error while waiting producing message");
                    break;
                }
            }
            if(!running)
                break;
            String UUID = java.util.UUID.randomUUID().toString();
            Message message = new Message(UUID, UUID + " generated");
            queue.add(message);
        }
    }

    public void stop() {
        running = false;
        queue.notifyOnEmpty();
    }
}
