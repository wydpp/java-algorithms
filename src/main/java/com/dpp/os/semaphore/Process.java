package com.dpp.os.semaphore;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: java-algorithms
 * @description:
 * @author: duanpp
 * @create: 2018-12-04 15:01
 **/
public class Process {
    private Condition condition;
    private Thread thread;
    private Lock lock;
    public Process(Lock lock,Condition c,Thread t){
        this.lock = lock;
        this.condition = c;
        this.thread = t;
    }

    public Condition getCondition() {
        return condition;
    }

    public Thread getThread() {
        return thread;
    }

    public Lock getLock() {
        return lock;
    }
}
