package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        HashMap<String, String> map = new HashMap<String, String>();
        while (true) {
            String city = reader.readLine();
            if(city.isEmpty()) break;
            String family = reader.readLine();

            map.put(city, family);
        }

        //read home number
        String city = reader.readLine();

        if(map.containsKey(city))
            System.out.println(map.get(city));
    }
}
