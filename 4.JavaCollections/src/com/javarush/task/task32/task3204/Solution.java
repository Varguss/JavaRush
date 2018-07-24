package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(32);

        for (int i = 0; i < 8; i++) {
            switch (i % 3) {
                case 0: {
                    outputStream.write('A' + (int) (Math.random() * 26));
                } break;
                case 1: {
                    outputStream.write('a' + (int) (Math.random() * 26));
                } break;
                case 2: {
                    outputStream.write('0' + (int) (Math.random() * 10));
                } break;
            }
        }

        return outputStream;
    }
}