package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> characters = new TreeSet<>();

        try (FileReader reader = new FileReader(args[0])) {
            int character = reader.read();

            do {
                if (Character.isLetter(character))
                    characters.add(Character.toLowerCase((char)character));
                character = reader.read();
            } while (character != -1);
        }

        characters.stream().limit(5).forEach(System.out::print);
    }
}
