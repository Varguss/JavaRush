package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream content = new ByteArrayOutputStream();

        PrintStream fake = new PrintStream(content);

        System.setOut(fake);

        testString.printSomething();

        System.setOut(console);

        String input[] = content.toString().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[2]);

        switch(input[1]) {
            case "+": {
                System.out.println(a + " " + input[1] + " " + b + " = " + (a+b));
            } break;
            case "-": {
                System.out.println(a + " " + input[1] + " " + b + " = " + (a-b));
            } break;
            case "*": {
                System.out.println(a + " " + input[1] + " " + b + " = " + (a*b));
            } break;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

