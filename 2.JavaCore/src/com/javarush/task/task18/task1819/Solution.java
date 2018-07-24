package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String file1 = r.readLine();
        String file2 = r.readLine();

        FileInputStream in1 = new FileInputStream(file1);
        FileInputStream in2 = new FileInputStream(file2);
        FileOutputStream out = new FileOutputStream(file1);

        byte[] file1data = new byte[in1.available()];

        for (int i = 0; i < file1data.length; i++)
            file1data[i] = (byte) in1.read();

        while (in2.available() > 0) {
            out.write(in2.read());
        }

        out.write(file1data);

        r.close();
        in1.close();
        in2.close();
        out.close();
    }
}