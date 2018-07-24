package com.javarush.task.task30.task3001;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class Validator {
    public static void main(String[] args) throws Exception {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(Task3001Test.class);

        PrintStream writer = new PrintStream(new FileOutputStream("d:/tests.txt"));

        writer.println("run tests: " + result.getRunCount());
        writer.println("failed tests: " + result.getFailureCount());
        writer.println("ignored tests: " + result.getIgnoreCount());
        writer.println("success: " + result.wasSuccessful());

        writer.close();
    }
}
