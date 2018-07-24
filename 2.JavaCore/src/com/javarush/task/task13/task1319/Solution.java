package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        for(String s = reader.readLine();; s = reader.readLine()) {
                char[] array = s.toCharArray();
                for (int i = 0; i < array.length; i++) {
                    writer.write((byte) array[i]);

                }
                writer.newLine();
                if(s.equals("exit"))
                    break;
        }

        reader.close();
        writer.close();
    }
}
