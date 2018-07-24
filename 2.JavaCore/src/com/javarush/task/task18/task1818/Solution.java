package com.javarush.task.task18.task1818;

/* 
Два в одном
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file1 = r.readLine();
        String file2 = r.readLine();
        String file3 = r.readLine();

        FileOutputStream out = new FileOutputStream(file1);
        FileInputStream in1 = new FileInputStream(file2);
        FileInputStream in2 = new FileInputStream(file3);

        while(in1.available() > 0) {
            int data = in1.read();
            out.write(data);
        }
        while(in2.available() > 0) {
            int data = in2.read();
            out.write(data);
        }

        r.close();
        out.close();
        in1.close();
        in2.close();
    }

}
