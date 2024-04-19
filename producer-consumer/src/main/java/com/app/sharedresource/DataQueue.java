package com.app.sharedresource;

import java.util.LinkedList;
import java.util.Queue;

public class DataQueue {
    private Queue<Message> queue;
    private int maxCap;
    private Object OBJ_NOT_FULL = new Object();
    private Object OBJ_NOT_EMPTY = new Object();

    public DataQueue(int maxCap) {
        this.maxCap = maxCap;
        queue = new LinkedList<>();
    }

    public void add(Message message) {
        queue.add(message);
        notifyOnEmpty();
    }

    public Message remove() {
        Message message = queue.poll();
        notifyOnFull();
        return message;
    }

    public boolean isFull() {
        return queue.size() == maxCap;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void waitOnFull() throws InterruptedException {
        synchronized (OBJ_NOT_FULL) {
            OBJ_NOT_FULL.wait();
        }
    }

    public void notifyOnFull() {
        synchronized (OBJ_NOT_FULL) {
            OBJ_NOT_FULL.notify();
        }
    }

    public void waitOnEmpty() throws InterruptedException {
        synchronized (OBJ_NOT_EMPTY) {
            OBJ_NOT_EMPTY.wait();
        }
    }

    public void notifyOnEmpty() {
        synchronized (OBJ_NOT_EMPTY) {
            OBJ_NOT_EMPTY.notify();
        }
    }
}
