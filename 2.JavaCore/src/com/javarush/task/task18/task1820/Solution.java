package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream stream = new FileInputStream(file1);
        PrintWriter writer = new PrintWriter(new FileOutputStream(file2));

        StringBuilder result = new StringBuilder();

        while(stream.available() > 0)
            result.append(Math.round(readDouble(stream))).append(' ');

        writer.print(result.toString().trim());

        reader.close();
        stream.close();
        writer.close();
    }

    private static double readDouble(FileInputStream stream) throws IOException {
        StringBuilder result = new StringBuilder();

        while(stream.available() > 0) {
            int read = stream.read();
            if((char) read != ' ')
                result.append((char) read);
            else
                break;
        }

        return Double.parseDouble(result.toString());
    }
}
