package com.example.demo2.Question4;

public class ConsumerProducer {

    public static void main(String args[]) throws Exception {
        final BlockingIntegerQueue q = new BlockingIntegerQueue(1);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 50; i++) {
                        q.enqueue(i);
                        System.out.println("enqueued " + i);
                    }
                } catch (InterruptedException ie) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 25; i++) {
                        System.out.println("Thread 2 dequeued: " + q.dequeue());
                    }
                } catch (InterruptedException ie) {
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 25; i++) {
                        System.out.println("Thread 3 dequeued: " + q.dequeue());
                    }
                } catch (InterruptedException ie) {
                }
            }
        });
        t1.start();
        Thread.sleep(4000);
        t2.start();
        t2.join();
        t3.start();
        t1.join();
        t3.join();
    }
}


class BlockingIntegerQueue {
    int[] array;
    Object lock = new Object();
    int size = 0, head = 0, tail = 0, capacity;

    public BlockingIntegerQueue(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
    }

    public void enqueue(int item) throws InterruptedException {
        synchronized (lock) {
            while (size == capacity) {
                lock.wait();
            }
            if (tail == capacity) {
                tail = 0;
            }
            array[tail] = item;
            size++;
            tail++;
            lock.notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        int item = -1;
        synchronized (lock) {
            while (size == 0) {
                lock.wait();
            }
            if (head == capacity) {
                head = 0;
            }
            item = array[head];
            array[head] = -1;
            head++;
            size--;
            lock.notifyAll();
        }
        return item;
    }
}