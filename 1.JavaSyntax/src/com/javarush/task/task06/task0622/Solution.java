package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());
        int n3 = Integer.parseInt(reader.readLine());
        int n4 = Integer.parseInt(reader.readLine());
        int n5 = Integer.parseInt(reader.readLine());

        for(int i = 0; i < 5; i++)
        {
            if(n1 > n2)
            {
                int t = n1;
                n1 = n2;
                n2 = t;
            }

            if(n2 > n3)
            {
                int t = n2;
                n2 = n3;
                n3 = t;
            }

            if(n3 > n4)
            {
                int t = n3;
                n3 = n4;
                n4 = t;
            }

            if(n4 > n5)
            {
                int t = n4;
                n4 = n5;
                n5 = t;
            }
        }

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
    }
}
