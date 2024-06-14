package com.dpp.stack;

/**
 * @author dpp
 * @date 2024/6/14
 * @Description 使用栈实现一个队列
 */
public class StackQueue {

    ArrayStack stack1 = new ArrayStack(10);

    ArrayStack stack2 = new ArrayStack(10);

    /**
     * 入队
     * @param element 入队的元素
     */
    public void enQueue(int element){
        stack1.push(element);
    }

    /**
     * 出队
     * @return stack2头元素
     */
    public int deQueue(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue(4);
        queue.enQueue(5);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }

}
