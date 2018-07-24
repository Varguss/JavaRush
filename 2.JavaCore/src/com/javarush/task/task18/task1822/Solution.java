package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        boolean isFound = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        BufferedReader freader = new BufferedReader(new FileReader(file));

        String line = "";

        while(freader.ready()) {
            line = freader.readLine();
            if(Integer.parseInt(line.split(" ")[0]) == Integer.parseInt(args[0]))
            {
                isFound = true;
                break;
            }
        }

        if(isFound)
            System.out.println(line);

        freader.close();
        reader.close();
    }
}
