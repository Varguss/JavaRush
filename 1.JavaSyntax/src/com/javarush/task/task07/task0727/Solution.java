package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;

            list.add(s);
        }

        for (int i = 0, listsize = list.size(); i < listsize; i++) {
            String s = list.get(i);
            String ex = s;
            if(s.length() % 2 == 0)
                s = ex + " " + ex;
            else
                s = ex + " " + ex + " " + ex;
            list.set(i, s);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
