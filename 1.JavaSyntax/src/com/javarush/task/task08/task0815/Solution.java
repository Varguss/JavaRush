package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Shestukhin","Yaroslav");
        map.put("Herold","Lena");
        map.put("Ivanovich","Dmitriy");
        map.put("Ivanov","Franko");
        map.put("Hawking","Kirill");
        map.put("Petter","Debil");
        map.put("Geus","Lerroy");
        map.put("Xenos","Jenkins");
        map.put("Lerik","Lalala");
        map.put("Clerik","Bebebe");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int instances = 0;
        for(String a : map.values())
            if(a.intern()==name.intern())
                instances++;
        return instances;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int instances = 0;
        for(String a : map.keySet())
            if(a.intern()==lastName.intern())
                instances++;
        return instances;
    }

    public static void main(String[] args) {

    }
}
