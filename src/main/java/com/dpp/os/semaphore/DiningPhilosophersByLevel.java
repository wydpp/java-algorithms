package com.dpp.os.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @program: java-algorithms
 * @description: 哲学家就餐问题-资源分级法
 * @author: duanpp
 * @create: 2018-12-04 16:28
 **/
public class DiningPhilosophersByLevel {

    private static class Fork{
        private Semaphore semaphore;
        private int level;

        public Fork(Semaphore semaphore, int level) {
            this.semaphore = semaphore;
            this.level = level;
        }

        public Semaphore getSemaphore() {
            return semaphore;
        }

        public int getLevel() {
            return level;
        }
    }

    /**
     * 哲学家
     */
    private static class Philosopher implements Runnable{

        private Fork big;

        private Fork small;

        private String name;

        public Philosopher(String name,Fork l,Fork r){
            this.name = name;
            if(l.getLevel()<r.getLevel()){
                small = l;
                big = r;
            }else{
                small = r;
                big = l;
            }
        }

        /**
         * 每位哲学家在就餐拿筷子的时候，只能先拿级别比较低的筷子，然后才能拿级别比较高的。用餐完以后，先放下级别比较高的筷子，再放下编号比较低的
         */
        @Override
        public void run() {
            try {
                //级别低的
                small.getSemaphore().acquire();
                //级别高的
                big.getSemaphore().acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+" 吃饭");
            small.getSemaphore().release();
            big.getSemaphore().release();
        }

    }

    public static void main(String[] args) {
        //设置5个有等级的互斥的叉子
        Semaphore s1 = new Semaphore(1);
        Fork f1 = new Fork(s1,1);
        Semaphore s2 = new Semaphore(1);
        Fork f2 = new Fork(s2,2);
        Semaphore s3 = new Semaphore(1);
        Fork f3 = new Fork(s3,3);
        Semaphore s4 = new Semaphore(1);
        Fork f4 = new Fork(s4,4);
        Semaphore s5 = new Semaphore(1);
        Fork f5 = new Fork(s5,5);
        //创建5个哲学家
        List<Philosopher> philosophers = new ArrayList<>();
        philosophers.add(new Philosopher("牛顿",f1,f2));
        philosophers.add(new Philosopher("爱因斯坦",f2,f3));
        philosophers.add(new Philosopher("伽利略",f3,f4));
        philosophers.add(new Philosopher("达尔文",f4,f5));
        philosophers.add(new Philosopher("爱迪生",f5,f1));
        for(Philosopher p:philosophers){
            new Thread(p).start();
        }

    }
}
