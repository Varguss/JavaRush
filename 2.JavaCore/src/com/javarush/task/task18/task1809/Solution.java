package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(r.readLine());
        FileOutputStream out = new FileOutputStream(r.readLine());
        ArrayList<Integer> bytes = new ArrayList<Integer>();

        while(in.available() > 0)
            bytes.add(in.read());

        Collections.reverse(bytes);

        for(int i = 0; i < bytes.size(); i++)
            out.write(bytes.get(i));
    }
}
