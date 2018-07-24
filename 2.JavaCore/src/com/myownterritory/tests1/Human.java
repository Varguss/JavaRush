package com.myownterritory.tests1;

/**
 * Created by user on 26.06.2017.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/*
Парсер реквестов
*/

public class Human {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(console.readLine()));
        StringBuilder lines = new StringBuilder();

        while (fileReader.ready())
            lines.append(fileReader.readLine()).append(" ");

        int count = (int)Arrays.stream(lines.toString().split("\\W")).filter("world"::equals).count();
        System.out.println(count);

        fileReader.close();
    }
}