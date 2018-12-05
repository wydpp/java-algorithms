package com.dpp.os.semaphore;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ASemaphore {

    /**
     * W(s.queue)表示把调用过程的进程置成等待信号量 s 的状态， 并链入 s 信号量队列，同时释放 CPU
     */
    public void w(Queue<Process> queue){
        try {
            Lock lock = new ReentrantLock();
            lock.lock();
            //调用p()的线程进入等待状态，并放入队列queue中,同时释放cpu
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+" 等待 !");
            Condition c = lock.newCondition();
            Process p = new Process(lock,c,thread);
            queue.offer(p);
            c.await();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * R(s.queue)表示释放一个等待信号量 s 的进程，从信号量 s 队列中移出一个进程，置成就绪态并投入就绪队列.
     * 进程按照什么次序从队列中移出?公平的策略是先进先出法，被阻塞时间最久的进程最先从队列释放，该策略能保证进程不会被饿死.
     */
    public void r(Queue<Process> queue){
        Process p = queue.poll();
        if(p != null){
            System.out.println(Thread.currentThread().getName()+" 释放一个等待的线程："+p.getThread().getName());
            p.getLock().lock();
            p.getCondition().signal();
            p.getLock().unlock();
        }
    }
}
