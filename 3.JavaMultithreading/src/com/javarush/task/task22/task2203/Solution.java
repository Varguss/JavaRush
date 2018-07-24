package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
        int first = string.indexOf("\t");
        int second = string.indexOf("\t", first+1);
        return string.substring(first+1, second);
        } catch (StringIndexOutOfBoundsException | NullPointerException e) {
            TooShortStringException exception = new TooShortStringException();
            exception.initCause(e);
            throw exception;
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
