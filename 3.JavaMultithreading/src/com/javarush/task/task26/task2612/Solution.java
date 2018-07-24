package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        boolean isLocked = !lock.tryLock();

        if (isLocked) {
            ifLockIsBusy();
        } else {
            try {
                ifLockIsFree();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void ifLockIsFree() {
    }

    public void ifLockIsBusy() {
    }
}
