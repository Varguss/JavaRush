package com.javarush.task.task18.task1803;

import java.io.*;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        String fileName = r.readLine();
        FileInputStream stream = new FileInputStream(fileName);

        while(stream.available()>0)
            list.add(stream.read());

        for(Integer a : list) {
            int reply = 0;
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).equals(a))
                    reply++;
            }
            map.put(a, reply);
        }

        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer max = new Integer(entry.getValue());
            for(Integer m : map.values())
                if(m>max)
                    max = m;

            if(entry.getValue().equals(max))
                System.out.printf("%d ", entry.getKey());
        }

        stream.close();
        r.close();
    }
}
