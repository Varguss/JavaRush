package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Dugestan", new Date("AUG 1 1980"));
        map.put("Ivan", new Date("JUNE 1 1980"));
        map.put("Piter", new Date("JUNE 1 1980"));
        map.put("Herold", new Date("JUNE 1 1980"));
        map.put("Zeus", new Date("JUNE 1 1980"));
        map.put("Mouse", new Date("JUNE 1 1980"));
        map.put("Helus", new Date("JUNE 1 1980"));
        map.put("Teus", new Date("JULY 1 1980"));
        map.put("Zex", new Date("DECEMBER 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        HashMap<String, Date> external = new HashMap<String, Date>(map);
        for(HashMap.Entry<String, Date> entry : external.entrySet())
        {
            if((entry.getValue().toString().contains("Jun")) || (entry.getValue().toString().contains("Jul")) || (entry.getValue().toString().contains("Aug")))
                map.remove(entry.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
