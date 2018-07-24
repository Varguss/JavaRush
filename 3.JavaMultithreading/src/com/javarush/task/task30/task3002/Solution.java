package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        try {
            if (s.contains("x"))
                return String.valueOf(Integer.parseInt(s.substring(2), 16));

            if (s.contains("b"))
                return String.valueOf(Integer.parseInt(s.substring(2), 2));

            if (s.startsWith("0"))
                return String.valueOf(Integer.parseInt(s, 8));

            return String.valueOf(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
