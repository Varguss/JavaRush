package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {

        public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
            synchronized (obj1) {
                synchronized (obj2) {
                    System.out.println(obj1 + " " + obj2);
                }
            }
        }

        public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread thread1 = new Thread(() -> {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (o2) {

                }
            }
        });


        Thread thread2 = new Thread(() -> {
            solution.someMethodWithSynchronizedBlocks(o1 ,o2);
        });

        thread1.start();

        Thread.sleep(200);

        thread2.start();

        Thread.sleep(1000);

        /*
        1. Первая нить синхронизируется по 1 объекту, ждет 500 мс и синхронизируется по второму.
         */
        return thread1.getState() != Thread.State.BLOCKED;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
