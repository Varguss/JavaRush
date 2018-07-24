package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream content = new ByteArrayOutputStream();

        PrintStream fake = new PrintStream(content);

        System.setOut(fake);

        System.out.println("Hello, world!");

        System.setOut(console);

        System.err.println(content.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
