package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> content = new ArrayList<>();

        try {
            FileInputStream is = new FileInputStream(args[1]);
            FileOutputStream os = new FileOutputStream(args[2]);

            byte[] data = new byte[is.available()];
            is.read(data);

            if(args[0].equals("-e"))
                os.write(encode(data));
            if(args[0].equals("-d"))
                os.write(decode(data));

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] encode(byte[] input) {
        for(int i = 0; i < input.length; i++) {
            input[i] += 2;
        }

        return input;
    }

    private static byte[] decode(byte[] input) {
        for(int i = 0; i < input.length; i++) {
            input[i] -= 2;
        }

        return input;
    }
}
