package com.dpp.stack;

/**
 * 数组实现队列
 */
public class ArrayQueue {
    private int[] data;

    private int head = 0;

    private int tail = 0;

    private int size;

    public ArrayQueue(int size) {
        this.data = new int[size];
        this.size = size;
    }

    public boolean enQueue(int val) {
        if (tail == size) {
            if (head == 0){
                return false;
            }
            //移动数组
            for (int i = head; i < tail; i++) {
                data[i - head] = data[i];
            }
            tail = tail - head;
            head = 0;
            data[tail++] = val;
        }else {
            data[tail++] = val;
        }
        return true;
    }

    public int deQueue(){
        if (head == tail){
            throw new RuntimeException("队列为空");
        }
        return data[head++];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
