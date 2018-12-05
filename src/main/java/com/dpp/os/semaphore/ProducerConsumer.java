package com.dpp.os.semaphore;

import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @program: java-algorithms
 * @description: 生产者消费者问题
 * @author: duanpp
 * @create: 2018-12-05 11:05
 **/
public class ProducerConsumer {

    /**
     * 产品缓冲池
     */
    private static class ProductBuffer{
        private static final int k = 10;
        /**
         * 产品缓冲器(最多k个产品)
         */
        private final Product[] buffer = new Product[k];
        /**
         * 可以使用的空缓冲区数
         */
        private Semaphore empty = new Semaphore(k);
        /**
         * 缓冲区内可以使用的产品数
         */
        private Semaphore full = new Semaphore(0);
        /**
         * 互斥信号量
         */
        private Semaphore mutex = new Semaphore(1);
        /**
         * 放入缓冲区指针
         */
        private volatile Integer in = 0;
        /**
         * 取出缓冲区指针
         */
        private volatile Integer out = 0;

        public void push(Product p){
            buffer[in] = p;
            System.out.println("in="+in);
            in = (in+1)%k;
        }
        public Product pop(){
            Product p = buffer[out];
            buffer[out] = null;
            System.out.println("out="+out);
            out = (out+1)%k;
            return p;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("ProductBuffer{");
            sb.append("buffer=").append(Arrays.toString(buffer));
            sb.append(", empty=").append(empty);
            sb.append(", full=").append(full);
            sb.append(", mutex=").append(mutex);
            sb.append(", in=").append(in);
            sb.append(", out=").append(out);
            sb.append('}');
            return sb.toString();
        }
    }

    private static class Product{
        private String id;
        public Product(String id) {
            this.id = id;
        }
    }

    /**
     * 生产者
     */
    private static class Producer implements Runnable{

        private ProductBuffer buffer;

        public Producer(ProductBuffer buffer){
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                System.out.println("开始生产！");
                buffer.empty.acquire();
                buffer.mutex.acquire();
                Product p = new Product("产品"+Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
                buffer.push(p);
                System.out.println("生产了一个产品:id="+p.id);
                buffer.mutex.release();
                buffer.full.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费者
     */
    private static class Consumer implements Runnable{
        private ProductBuffer buffer;
        public Consumer(ProductBuffer buffer){
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                buffer.full.acquire();
                buffer.mutex.acquire();
                System.out.println("开始消费！");
                Product p = buffer.pop();
                TimeUnit.SECONDS.sleep(1);
                System.out.println("消费了一个产品:id="+p.id);
                buffer.mutex.release();
                buffer.empty.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProductBuffer buffer = new ProductBuffer();
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(buffer)).start();
        }
        Thread.sleep(1000);
        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(buffer)).start();
        }
    }
}
