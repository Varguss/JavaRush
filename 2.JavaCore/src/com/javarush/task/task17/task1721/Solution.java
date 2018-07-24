package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = "", file2 = "";
        try {
            file1 = reader.readLine();
            file2 = reader.readLine();
            reader.close();
        } catch (IOException e) {
        }

        try (BufferedReader filereader = new BufferedReader(new FileReader(file1))) {
            while(filereader.ready())
                allLines.add(filereader.readLine());
        } catch (IOException e) {
        }

        try (BufferedReader filereader = new BufferedReader(new FileReader(file2))) {
            while(filereader.ready())
                forRemoveLines.add(filereader.readLine());
        } catch (IOException e) {
            System.err.println("Ошибка считывания второго файла.");
            System.exit(1);
        }

        try {
            Solution solution = new Solution();
            solution.joinData();
        } catch (CorruptedDataException e) {
            System.err.println("Ошибка поврежденных данных.");
        }


    }

    public void joinData () throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
