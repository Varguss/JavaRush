package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file1 = r.readLine();
        String file2 = r.readLine();

        FileReader reader = new FileReader(file1);
        FileWriter writer = new FileWriter(file2);

        int index = 0;
        while(reader.ready()) {
            index++;
            int readed = reader.read();
            if(index%2==0)
                writer.write(readed);
        }

        r.close();
        reader.close();
        writer.close();
    }
}
