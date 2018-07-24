package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    /*
    В отдельном файле создайте класс Producer, который будет:
1. каждые полсекунды добавлять в ConcurrentHashMap ключ и значение, где ключ - счетчик начиная с 1, значение - фраза: "Some text for i" , пример "Some text for 1".
2. при возникновении исключения выводить в консоль: "[TREAD_NAME] thread was terminated", пример "[thread-1] thread was terminated".
     */
    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread thread = Thread.currentThread();
        int i = 1;
        while (true) {
            try {
                map.put(Integer.toString(i), "Some text for " + i++);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("[" + thread.getName() + "]" + " thread was terminated");
                break;
            }
        }
    }
}
