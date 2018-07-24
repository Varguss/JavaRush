package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");

            int position = Integer.parseInt(args[1]);

            if (position <= randomAccessFile.length())
                randomAccessFile.seek(position);
            else
                randomAccessFile.seek(randomAccessFile.length());

            randomAccessFile.write(args[2].getBytes());

            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
