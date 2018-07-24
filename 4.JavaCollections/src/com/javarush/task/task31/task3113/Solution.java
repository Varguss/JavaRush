package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import java.util.PriorityQueue;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Path path = Paths.get(reader.readLine());

        if (Files.isRegularFile(path)) {
            System.out.println(path + " - не папка");
            return;
        }

        PriorityQueue<Path> directoriesQueue = new PriorityQueue<>();
        directoriesQueue.offer(path);

        long size = 0;
        int files = 0, directories = 0;

        while (directoriesQueue.size() > 0) {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoriesQueue.poll());

            Iterator<Path> iterator = directoryStream.iterator();

            while (iterator.hasNext()) {
                Path current = iterator.next();

                if (Files.isDirectory(current)) {
                    directories++;
                    directoriesQueue.offer(current);
                } else {
                    size += Files.size(current);
                    files++;
                }
            }
        }

        System.out.println("Всего папок - " + directories);
        System.out.println("Всего файлов - " + files);
        System.out.println("Общий размер - " + size);
    }
}
