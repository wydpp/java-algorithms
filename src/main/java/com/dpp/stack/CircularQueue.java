package com.dpp.stack;

/**
 * @author dpp
 * @date 2024/6/17
 * @Description 循环队列
 */
public class CircularQueue {

    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    /**
     * 环形数组容量少一个，所以此处+1，使真实容量=capacity
     * @param capacity
     */
    public CircularQueue(int capacity) {
        items = new String[++capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        System.out.println(queue.dequeue());
        queue.enqueue("4");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }


}
