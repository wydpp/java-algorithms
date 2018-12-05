package com.dpp.os.semaphore;

/**
 * @program: java-algorithms
 * @description: 整型信号量:设 s 为一个正整形量，除初始化外，仅能通过 P、 V 操作来访问它，这时 P 操作原语和 V 操作原语定义如下
 * @author: duanpp
 * @create: 2018-12-04 11:20
 **/
public class IntegerSemaphore extends ASemaphore {
    /**
     * s为一个正整形量，除初始化外，仅能通过 P、 V 操作来访问它
     */
    private int s;

    /**
     * 初始化s
     * @param s
     */
    public IntegerSemaphore(int s){
        this.s = s;
    }

    /**
     * 当信号量 s 大于 0 时，把信号量 s 减去 l，否则调用 P(s)的进程等待直到信号量 s 大于 0 时。
     */
    public void p(){
        while(s<=0){
            //等待直到信号量 s 大于 0
        }
        //s=s-1
        s--;
    }

    /**
     * 把信号量s加1
     */
    public void s(){
        s++;
    }



}
