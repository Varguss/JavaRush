package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length-1; i++) {
            if (i == 0 && Character.isLetter(chars[i]))
                chars[i] = Character.toUpperCase(chars[i]);

            if ((chars[i] == ' ') && (Character.isLetter(chars[i + 1])))
                chars[i + 1] = Character.toUpperCase(chars[i + 1]);
        }

        for(char a : chars)
            System.out.print(a);
    }
}
