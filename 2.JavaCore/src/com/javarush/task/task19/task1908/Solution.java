package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
            List<String> list = new ArrayList<>();
            while(reader.ready())
                list.add(reader.readLine());

            list.forEach((str) -> {
                String parts[] = str.split(" ");
                for(String s : parts) {
                    try {
                        writer.write(Integer.parseInt(s) + " ");
                    } catch (NumberFormatException e) {
                        continue;
                    } catch (IOException e) {
                        continue;
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
