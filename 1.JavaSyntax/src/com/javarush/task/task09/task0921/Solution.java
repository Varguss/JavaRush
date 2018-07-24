package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {

    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        while(true) {
            try {
                double m = Double.parseDouble(reader.readLine());
                String string = Double.toString(m);

                if(string.split("\\.")[1].equals("0"))
                    list.add(string.split("\\.")[0]);
                else
                    list.add(string);

            } catch (NumberFormatException e) {
                for (String m : list)
                    System.out.println(m);
                return;
            } catch (IOException ee) {
                ee.printStackTrace();
            }
        }
    }
}
