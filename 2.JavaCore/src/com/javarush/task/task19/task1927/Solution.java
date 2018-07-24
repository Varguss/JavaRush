package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.*;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.*;
import java.util.concurrent.Callable;

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("a","a");
        map.put("b","a");
        map.put("c","b");
        map.put("d","c");
        map.put("e","b");
        map.put("f","b");
        map.put("g","e");
        map.put("h","f");
        map.put("i","a");
        map.put("j","f");
        return map;
    }

    public static HashMap<String, String> removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            String s = pair.getValue();
            int n = 0;
            for (Map.Entry<String, String> pair1 : copy.entrySet()) {
                if (pair1.getValue().equals(s))
                    n++;
            }
            if (n > 1)
                removeItemFromMapByValue(map, s);
        }
        return map;
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        for (Map.Entry<String, String> pair : removeTheFirstNameDuplicates(createMap()).entrySet()) {
            System.out.println(pair.getValue());
        }
    }
}

