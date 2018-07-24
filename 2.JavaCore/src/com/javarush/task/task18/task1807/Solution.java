package com.javarush.task.task18.task1807;
import java.io.*;
/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream s = new FileInputStream(r.readLine());
        int count = 0;

        while(s.available() > 0) {
            int data = s.read();
            if(data == 44)
                count++;
        }

        System.out.println(count);
        r.close();
        s.close();
    }
}
