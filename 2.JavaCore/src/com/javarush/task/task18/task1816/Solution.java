package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream(args[0]);
        int count = 0;
        while(stream.available() > 0) {
            int data = stream.read();
            if(((byte)data>=65 && (byte)data<=90) || ((byte)data>=97 && (byte)data<=122))
                count++;
        }
        System.out.println(count);
        stream.close();
    }
}