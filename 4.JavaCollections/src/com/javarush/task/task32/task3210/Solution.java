package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        int length = args[2].getBytes().length;

        int position = Integer.parseInt(args[1]);

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw")) {
            randomAccessFile.seek(position);

            byte[] textInFile = new byte[length];

            randomAccessFile.read(textInFile, 0, textInFile.length);

            String textFromFile = new String(textInFile);

            randomAccessFile.seek(randomAccessFile.length());

            if (textFromFile.equals(args[2]))
                randomAccessFile.write("true".getBytes());
            else
                randomAccessFile.write("false".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
