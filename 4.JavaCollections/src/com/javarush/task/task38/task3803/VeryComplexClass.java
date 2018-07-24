package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object object = 123L;

        String exception = (String) object;
    }

    public void methodThrowsNullPointerException() {
        Object nullObject = null;

        System.out.println(nullObject.hashCode());
    }

    public static void main(String[] args) {

    }
}
