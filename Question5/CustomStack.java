package com.example.demo2.Question5;

import java.util.LinkedList;
import java.util.Queue;

public class CustomStack {

    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        for (int i=1; i<queue.size(); i++)
            queue.add(queue.remove());
    }

    public void pop() {
        queue.remove();
    }

}
