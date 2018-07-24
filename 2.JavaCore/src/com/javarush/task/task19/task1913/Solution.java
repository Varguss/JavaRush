package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
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

        for(char a : content.toString().toCharArray())
            if(Character.isDigit(a))
                System.out.print(a);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
