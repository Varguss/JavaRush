package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Locale locale = new Locale("English");
        SimpleDateFormat enter = new SimpleDateFormat("MM/dd/y", locale);
        SimpleDateFormat outer = new SimpleDateFormat("MMM dd, y", locale);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        Date date = enter.parse(text);

        String result = outer.format(date);

        System.out.println(result.toUpperCase());
    }
}
