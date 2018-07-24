package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> sList = new ArrayList<String>();
        for(int i = 0; i < 5; i++)
            sList.add(r.readLine());
        sList.remove(2);
        for(int i = 0; i < sList.size(); i++)
            System.out.println(sList.get(sList.size()-i-1));
    }
}


