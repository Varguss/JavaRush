package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan");
        map.put("city", "Moskva");
        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        boolean isThereCorrectValue = false;

        StringBuilder builder = new StringBuilder();

        params.forEach( (key, value) -> {
            if(!(value == null))
                builder.append(String.format("%s = '%s' and ", key, value));
        });

        if(builder.length() == 0)
            return "";

        return builder.toString().substring(0, builder.length()-5);
    }
}
