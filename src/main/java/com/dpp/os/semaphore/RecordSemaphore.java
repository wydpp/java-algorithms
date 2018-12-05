package com.dpp.os.semaphore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: java-algorithms
 * @description: 记录型信号量模拟
 * @author: duanpp
 * @create: 2018-12-04 11:30
 **/
public class RecordSemaphore extends ASemaphore {

    /**
     * value 通常是一个具有非负初值的整型变量
     */
    private volatile Integer value;
    /**
     * queue 是一个初始状态为空的进程队列
     */
    private Queue<Process> queue = new ConcurrentLinkedQueue<>();

    public RecordSemaphore(int value){
        if(value<0){
            value = 0;
        }
        this.value = value;
    }

    /**
     * 将信号量 s 减去 l，若结果小于 0，则调用 P(s)的进程被置成等待信号量s 的状态
     */
    public void p(){
        boolean w = false;
        synchronized(value){
            value--;
            if (value<=0) {
                w = true;
            }
        }
        if (w){
            System.out.println(Thread.currentThread().getName()+" 需要等待！");
            w(queue);
        }else{
            System.out.println(Thread.currentThread().getName()+" 无需等待！");
        }
    }


    /**
     * 将信号量 s 加 1，若结果不大于 0，则释放一个等待信号量 s 的进程.
     */
    public synchronized void v(){
        boolean r = false;
        synchronized(value){
            value++;
            if (value<=0) {
                r = true;
            }
        }
        if(r){
            r(queue);
        }else{
            System.out.println(Thread.currentThread().getName()+" 没有需要释放的线程！");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RecordSemaphore{");
        sb.append("value=").append(value);
        sb.append(", queue.size=").append(queue.size());
        sb.append('}');
        return sb.toString();
    }

    static class ProcessRunnable implements Runnable{
        private RecordSemaphore semaphore;
        public ProcessRunnable(RecordSemaphore semaphore){
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" start run!!");
            semaphore.p();
            System.out.println(Thread.currentThread().getName()+" end run!!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RecordSemaphore semaphore = new RecordSemaphore(0);
        Thread t1 = new Thread(new ProcessRunnable(semaphore));
        t1.start();
        Thread t2 = new Thread(new ProcessRunnable(semaphore));
        t2.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println(semaphore);
        semaphore.v();
        System.out.println(semaphore);
        semaphore.v();
        System.out.println(semaphore);
        semaphore.v();
        System.out.println(semaphore);
    }

}
