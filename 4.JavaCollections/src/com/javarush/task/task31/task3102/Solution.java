package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> files = new ArrayList<>();

        PriorityQueue<File> queue = new PriorityQueue<>();

        File directory = new File(root);
        queue.offer(directory);

        while (queue.size() > 0) {
            File current = queue.poll();

            if (current.isFile()) {
                files.add(current.getAbsolutePath());
            } else {
                for (File file : current.listFiles()) {
                    if (file.isFile())
                        files.add(file.getAbsolutePath());
                    else
                        queue.offer(file);
                }
            }
        }

        return files;
    }

    public static void main(String[] args) throws IOException {
        //getFileTree("d:/Установки/Skyrim").forEach(System.out::println);
        Files.newDirectoryStream(Paths.get("d:/")).forEach(System.out::println);
    }
}
