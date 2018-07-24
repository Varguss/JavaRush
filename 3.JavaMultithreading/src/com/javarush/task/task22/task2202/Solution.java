package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            String parts[] = string.split(" ");

            StringBuilder builder = new StringBuilder();

            for(int i = 1; i <= 4; i++)
                builder.append(parts[i]).append(" ");

            return builder.toString().trim();
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            TooShortStringException exception = new TooShortStringException();
            exception.initCause(e);
            throw exception;
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
