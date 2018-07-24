package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

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

            while(reader.ready())
                writer.write(reader.readLine().replace(".", "!"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
