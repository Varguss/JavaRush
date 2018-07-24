package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
/*
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int count = 0;
        for(int i = 0; i < 10; i++)
            list.add(Integer.parseInt(r.readLine()));
        for(int i = 1; i < list.size(); i++)
        {
            if (list.get(i - 1).equals((list.get(i))))
            {
                if (count == 0)
                    count = 2;
                else
                    count++;
            }
            else
            {
                if (count > max)
                {
                    max = count;
                    count = 0;
                }
                else
                    count = 0;
            }
            if((i == 9) && (count > max))
                max = count;
        }
        System.out.println(max);
    }
}