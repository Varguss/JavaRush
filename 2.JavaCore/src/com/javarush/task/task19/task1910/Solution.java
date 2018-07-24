package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String file1 = "", file2 = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();
            file2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }


        try (BufferedReader reader = new BufferedReader(new FileReader(file1));
             BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {

            ArrayList<String> content = new ArrayList<>();

            while(reader.ready())
                content.add(reader.readLine());

            for(int i = 0; i < content.size(); i++) {
                String line = content.get(i);

                char[] chars = line.toCharArray();
                char[] result = new char[chars.length];

                int r = 0;

                for(int k = 0; k < chars.length; k++) {
                    if(Character.isLetter(chars[k]) || Character.isDigit(chars[k]) || Character.isWhitespace(chars[k])) {
                        result[r++] = chars[k];
                        //System.out.println(String.format("В ячейку %s было записано значение %c (%d)", r - 1, chars[k], (int) chars[k]));
                    }
                }

                writer.write(String.copyValueOf(result, 0, r));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
