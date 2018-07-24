package com.javarush.task.task13.task1317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 26.06.2017.
 */
public class charConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String chars = reader.readLine();
        char[] ch = chars.toCharArray();

        System.out.println((byte) ch[0]);
    }
}
