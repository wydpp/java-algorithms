package com.dpp.stack;

/**
 * @author dpp
 * @date 2024/6/14
 * @Description
 */
public class ArrayStack {

    private int [] data;

    private int count = 0;

    private int size;

    public ArrayStack(int size){
        data = new int[size];
        this.size = size;
    }

    public boolean push(int value){
        if (count == size){
            return false;
        }
        data[count] = value;
        count++;
        return true;
    }

    public int pop(){
        if (count == 0){
            throw new RuntimeException("stack is empty");
        }
        return data[--count];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
