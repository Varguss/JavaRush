package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName = r.readLine();


        FileInputStream stream = new FileInputStream(fileName);
        int min = stream.read();
        int read = 0;
        while(stream.available() > 0) {
            if((read = stream.read())<min) {
                min = read;
            }
        }
        System.out.println(min);
        stream.close();
    }
}
