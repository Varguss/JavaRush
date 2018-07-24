package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file1 = r.readLine();
        String file2 = r.readLine();
        String file3 = r.readLine();

        FileInputStream stream = new FileInputStream(file1);
        FileOutputStream fileStreamOne = new FileOutputStream(file2);
        FileOutputStream fileStreamTwo = new FileOutputStream(file3);

        if(stream.available()%2==0) {
            byte[] half1 = new byte[stream.available()/2];
            byte[] half2 = new byte[stream.available()/2];

            stream.read(half1);
            stream.read(half2);

            fileStreamOne.write(half1);
            fileStreamTwo.write(half2);
        } else {
            byte[] half1 = new byte[stream.available()/2 + 1];
            byte[] half2 = new byte[stream.available()/2];

            stream.read(half1);
            stream.read(half2);

            fileStreamOne.write(half1);
            fileStreamTwo.write(half2);
        }

        r.close();
        stream.close();
        fileStreamOne.close();
        fileStreamTwo.close();
    }
}
