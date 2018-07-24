package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        args[0].chars().forEach(System.out::println);
        try {
            if (args.length != 1)
                return;

            if (!args[0].matches("[+\\-]?[0-9a-zA-Z]+")) {
                System.out.println("incorrect");
                return;
            }

            char[] chars = args[0].toUpperCase().toCharArray();

            char max = chars[0], min = '2';

            for (int i = 1; i < chars.length; i++)
                if (chars[i] > max)
                    max = chars[i];

            boolean isNumber = Character.isDigit(max);

            if (isNumber)
                System.out.println((max + 1) < min ? min : (char) (max + 1));
            else {
                int system = max - 65 + 10 + 1;

                System.out.println(system);
            }
        } catch (Exception e) {

        }
    }
}