package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        PrintStream console = System.out;

        ByteArrayOutputStream content = new ByteArrayOutputStream();

        PrintStream fake = new PrintStream(content);

        System.setOut(fake);

        testString.printSomething();

        System.setOut(console);

        FileOutputStream stream = new FileOutputStream(file);

        stream.write(content.toByteArray());
        System.out.println(content.toString());

        stream.close();
        fake.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

