package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class<?> c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest annotation = c.getAnnotation(PrepareMyTest.class);

            for (String string : annotation.fullyQualifiedNames())
                System.out.println(string);
            return true;
        }

        return false;
    }

    public static boolean printValues(Class<?> c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest annotation = c.getAnnotation(PrepareMyTest.class);

            for (Class<?> clazz : annotation.value())
                System.out.println(clazz.getSimpleName());
            return true;
        }

        return false;
    }
}
