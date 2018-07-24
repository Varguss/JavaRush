package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Character> chars1 = new ArrayList<>();
        List<Character> chars2 = new ArrayList<>();

        String text = reader.readLine();

        for(char a : text.toCharArray()) {
            if(!Character.isLetter(a) && a!=',' && a!='.' && a!='!' && a!='-' && a!='?' && a!=':')
                continue;
            if(isVowel(a))
                chars1.add(a);
            else
                chars2.add(a);
        }

        for(char a : chars1)
            System.out.print(a + " ");

        System.out.println();

        for(char a : chars2)
            System.out.print(a + " ");
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}