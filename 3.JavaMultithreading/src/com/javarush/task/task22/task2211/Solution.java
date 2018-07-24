package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream(args[0]);
        OutputStream out = new FileOutputStream(args[1]);

        byte[] bytes = new byte[in.available()];

        in.read(bytes);

        String decoded = new String(bytes, "Windows-1251");

        out.write(decoded.getBytes("UTF-8"));

        in.close();
        out.close();
    }
}
