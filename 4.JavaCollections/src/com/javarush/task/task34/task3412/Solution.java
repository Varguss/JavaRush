package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Properties;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        logger.debug("Новое значение value#1 = " + value1 + "Новое значение value#2 = " + value2 + "Новое значение value#3 = " + value3);
    }

    public static void main(String[] args) {

    }

    public void calculateAndSetValue3(long value) {
        logger.trace("Выполнение входа в метод calculateAndSetValue3. value = {}", value);
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("Новое значение value = " + value);
        } else {
            value1 = (int) value;
            logger.debug("Новое значение value = " + value);
        }

    }

    public void printString() {
        logger.trace("Выполнение входа в метод printString");
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("Выполнение входа в метод printDateAsLong");
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        logger.trace("Выполнение входа в метод divide");
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("Деление на 0 запрещено!", e);
        }
    }

    public void setValue1(int value1) {
        this.value1 = value1;
        logger.debug("Предыдущее значение: " + value1 + ", новое значение: " + this.value1);
    }

    public void setValue2(String value2) {
        this.value2 = value2;
        logger.debug("Предыдущее значение: " + value2 + ", новое значение: " + this.value2);
    }

    public void setValue3(Date value3) {
        this.value3 = value3;
        logger.debug("Предыдущее значение: " + value3 + ", новое значение: " + this.value3);
    }
}
