package com.dpp.os.semaphore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: java-algorithms
 * @description: 二元信号量
 * @author: duanpp
 * @create: 2018-12-04 14:54
 **/
public class BinarySemaphore extends ASemaphore {

    /**
     * 值为0或1
     */
    private volatile Integer value;

    /**
     * queue 是一个初始状态为空的信号量队列
     */
    private Queue<Process> queue = new ConcurrentLinkedQueue<>();

    public BinarySemaphore(int value){
        if(value != 0 && value != 1){
            value = 0;
        }
        this.value = value;
    }

    public void bp(){
        boolean w = false;
        synchronized(value){
            if(value == 1){
                value = 0;
            }else{
                w = true;
            }
        }
        if(w){
            w(queue);
        }
    }


    public void bv(){
        boolean r = false;
        synchronized(value){
            if(queue.isEmpty()){
                value = 1;
            }else{
                r = true;
            }
        }
        if(r){
            r(queue);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BinarySemaphore{");
        sb.append("value=").append(value);
        sb.append(", queue.size=").append(queue.size());
        sb.append('}');
        return sb.toString();
    }

    static class ProcessRunnable implements Runnable{
        private BinarySemaphore semaphore;
        public ProcessRunnable(BinarySemaphore semaphore){
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" start run!!");
            semaphore.bp();
            System.out.println(Thread.currentThread().getName()+" end run!!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BinarySemaphore semaphore = new BinarySemaphore(0);
        Thread t1 = new Thread(new ProcessRunnable(semaphore));
        t1.start();
        Thread t2 = new Thread(new ProcessRunnable(semaphore));
        t2.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println(semaphore);
        semaphore.bv();
        System.out.println(semaphore);
        semaphore.bv();
        System.out.println(semaphore);
        semaphore.bv();
        System.out.println(semaphore);
    }

}
