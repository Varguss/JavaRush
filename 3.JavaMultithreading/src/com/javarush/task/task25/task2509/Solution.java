package com.javarush.task.task25.task2509;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Все не так легко, как кажется
*/
public class Solution extends ThreadPoolExecutor {
    public Solution(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        } else {
            return super.newTaskFor(callable);
        }
    }

//    static class Counter implements Runnable {
//        AtomicInteger integer = new AtomicInteger(0);
//
//        public void increment() {
//            integer.incrementAndGet();
//        }
//
//        public void decrement() {
//            integer.decrementAndGet();
//        }
//
//        public int get() {
//            return integer.get();
//        }
//
//        public void run() {
//            for(int i = 0; i < 10; i++) {
//                try {
//                    increment();
//                    System.out.println(get());
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public static void main(String[] args) {

    }
}