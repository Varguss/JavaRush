package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()) {
            String line[] = reader.readLine().split(" ");

            StringBuilder name = new StringBuilder();

            for (int i = 0; i < line.length - 3; i++)
                if (i < line.length - 4)
                    name.append(line[i]).append(" ");
                else
                    name.append(line[i]);

            SimpleDateFormat format = new SimpleDateFormat("dd M y");

            PEOPLE.add(new Person(name.toString(), format.parse(line[line.length - 3] + " " + line[line.length - 2] + " " + line[line.length - 1])));
        }

        reader.close();
    }
}
