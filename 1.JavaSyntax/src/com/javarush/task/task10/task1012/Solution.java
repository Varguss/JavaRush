package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        ArrayList<Integer> repeats = new ArrayList<>();

        for(int i = 0; i < alphabet.size(); i++)
            repeats.add(0);

        for(String s : list) {
            char[] chars = s.toCharArray();
            for(char a : chars)
                if(alphabet.contains(a))
                    repeats.set(alphabet.indexOf(a), repeats.get(alphabet.indexOf(a)) + 1);
        }

        for(int i = 0; i < alphabet.size(); i++) {
            System.out.println(alphabet.get(i) + " " + repeats.get(i));
        }
    }

}
