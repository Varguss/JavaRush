package com.javarush.task.task30.task3001;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task3001Test {
    @Test
    public void convertNumberFrom2NumerationSystemTest() {
        Number number = new Number(NumerationSystemType._2, "1111");

        assertEquals("Неправильный перевод в двоичную систему!", "1111", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._2).getDigit());
        assertEquals("Неправильный перевод в троичную систему!", "120", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._3).getDigit());
        assertEquals("Неправильный перевод в четверичную систему!", "33", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._4).getDigit());
        assertEquals("Неправильный перевод в пятеричную систему!", "30", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._5).getDigit());
        assertEquals("Неправильный перевод в шестеричную систему!", "23", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._6).getDigit());
        assertEquals("Неправильный перевод в семеричную систему!", "21", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._7).getDigit());
        assertEquals("Неправильный перевод в восьмеричную систему!", "17", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._8).getDigit());
        assertEquals("Неправильный перевод в девятичную систему!", "16", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._9).getDigit());
        assertEquals("Неправильный перевод в десятичную систему!", "15", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._10).getDigit());
        assertEquals("Неправильный перевод в двенадцатичную систему!", "13", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._12).getDigit());
        assertEquals("Неправильный перевод в шестнадцатеричную систему!", "f", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._16).getDigit());
    }

    @Test
    public void convertNumberFrom3NumerationSystemTest() {
        Number number = new Number(NumerationSystemType._3, "120");

        assertEquals("Неправильный перевод в двоичную систему!", "1111", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._2).getDigit());
        assertEquals("Неправильный перевод в троичную систему!", "120", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._3).getDigit());
        assertEquals("Неправильный перевод в четверичную систему!", "33", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._4).getDigit());
        assertEquals("Неправильный перевод в пятеричную систему!", "30", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._5).getDigit());
        assertEquals("Неправильный перевод в шестеричную систему!", "23", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._6).getDigit());
        assertEquals("Неправильный перевод в семеричную систему!", "21", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._7).getDigit());
        assertEquals("Неправильный перевод в восьмеричную систему!", "17", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._8).getDigit());
        assertEquals("Неправильный перевод в девятичную систему!", "16", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._9).getDigit());
        assertEquals("Неправильный перевод в десятичную систему!", "15", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._10).getDigit());
        assertEquals("Неправильный перевод в двенадцатичную систему!", "13", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._12).getDigit());
        assertEquals("Неправильный перевод в шестнадцатеричную систему!", "f", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._16).getDigit());
    }

    @Test
    public void convertNumberFrom4NumerationSystemTest() {
        Number number = new Number(NumerationSystemType._4, "33");

        assertEquals("Неправильный перевод в двоичную систему!", "1111", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._2).getDigit());
        assertEquals("Неправильный перевод в троичную систему!", "120", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._3).getDigit());
        assertEquals("Неправильный перевод в четверичную систему!", "33", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._4).getDigit());
        assertEquals("Неправильный перевод в пятеричную систему!", "30", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._5).getDigit());
        assertEquals("Неправильный перевод в шестеричную систему!", "23", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._6).getDigit());
        assertEquals("Неправильный перевод в семеричную систему!", "21", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._7).getDigit());
        assertEquals("Неправильный перевод в восьмеричную систему!", "17", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._8).getDigit());
        assertEquals("Неправильный перевод в девятичную систему!", "16", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._9).getDigit());
        assertEquals("Неправильный перевод в десятичную систему!", "15", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._10).getDigit());
        assertEquals("Неправильный перевод в двенадцатичную систему!", "13", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._12).getDigit());
        assertEquals("Неправильный перевод в шестнадцатеричную систему!", "f", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._16).getDigit());
    }

    @Test
    public void convertNumberFrom5NumerationSystemTest() {
        Number number = new Number(NumerationSystemType._5, "30");

        assertEquals("Неправильный перевод в двоичную систему!", "1111", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._2).getDigit());
        assertEquals("Неправильный перевод в троичную систему!", "120", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._3).getDigit());
        assertEquals("Неправильный перевод в четверичную систему!", "33", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._4).getDigit());
        assertEquals("Неправильный перевод в пятеричную систему!", "30", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._5).getDigit());
        assertEquals("Неправильный перевод в шестеричную систему!", "23", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._6).getDigit());
        assertEquals("Неправильный перевод в семеричную систему!", "21", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._7).getDigit());
        assertEquals("Неправильный перевод в восьмеричную систему!", "17", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._8).getDigit());
        assertEquals("Неправильный перевод в девятичную систему!", "16", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._9).getDigit());
        assertEquals("Неправильный перевод в десятичную систему!", "15", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._10).getDigit());
        assertEquals("Неправильный перевод в двенадцатичную систему!", "13", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._12).getDigit());
        assertEquals("Неправильный перевод в шестнадцатеричную систему!", "f", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._16).getDigit());
    }

    @Test
    public void convertNumberFrom6NumerationSystemTest() {
        Number number = new Number(NumerationSystemType._6, "23");

        assertEquals("Неправильный перевод в двоичную систему!", "1111", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._2).getDigit());
        assertEquals("Неправильный перевод в троичную систему!", "120", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._3).getDigit());
        assertEquals("Неправильный перевод в четверичную систему!", "33", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._4).getDigit());
        assertEquals("Неправильный перевод в пятеричную систему!", "30", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._5).getDigit());
        assertEquals("Неправильный перевод в шестеричную систему!", "23", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._6).getDigit());
        assertEquals("Неправильный перевод в семеричную систему!", "21", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._7).getDigit());
        assertEquals("Неправильный перевод в восьмеричную систему!", "17", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._8).getDigit());
        assertEquals("Неправильный перевод в девятичную систему!", "16", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._9).getDigit());
        assertEquals("Неправильный перевод в десятичную систему!", "15", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._10).getDigit());
        assertEquals("Неправильный перевод в двенадцатичную систему!", "13", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._12).getDigit());
        assertEquals("Неправильный перевод в шестнадцатеричную систему!", "f", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._16).getDigit());
    }

    @Test
    public void convertNumberFrom7NumerationSystemTest() {
        Number number = new Number(NumerationSystemType._7, "21");

        assertEquals("Неправильный перевод в двоичную систему!", "1111", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._2).getDigit());
        assertEquals("Неправильный перевод в троичную систему!", "120", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._3).getDigit());
        assertEquals("Неправильный перевод в четверичную систему!", "33", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._4).getDigit());
        assertEquals("Неправильный перевод в пятеричную систему!", "30", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._5).getDigit());
        assertEquals("Неправильный перевод в шестеричную систему!", "23", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._6).getDigit());
        assertEquals("Неправильный перевод в семеричную систему!", "21", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._7).getDigit());
        assertEquals("Неправильный перевод в восьмеричную систему!", "17", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._8).getDigit());
        assertEquals("Неправильный перевод в девятичную систему!", "16", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._9).getDigit());
        assertEquals("Неправильный перевод в десятичную систему!", "15", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._10).getDigit());
        assertEquals("Неправильный перевод в двенадцатичную систему!", "13", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._12).getDigit());
        assertEquals("Неправильный перевод в шестнадцатеричную систему!", "f", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._16).getDigit());
    }

    @Test
    public void convertNumberFrom8NumerationSystemTest() {
        Number number = new Number(NumerationSystemType._8, "17");

        assertEquals("Неправильный перевод в двоичную систему!", "1111", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._2).getDigit());
        assertEquals("Неправильный перевод в троичную систему!", "120", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._3).getDigit());
        assertEquals("Неправильный перевод в четверичную систему!", "33", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._4).getDigit());
        assertEquals("Неправильный перевод в пятеричную систему!", "30", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._5).getDigit());
        assertEquals("Неправильный перевод в шестеричную систему!", "23", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._6).getDigit());
        assertEquals("Неправильный перевод в семеричную систему!", "21", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._7).getDigit());
        assertEquals("Неправильный перевод в восьмеричную систему!", "17", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._8).getDigit());
        assertEquals("Неправильный перевод в девятичную систему!", "16", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._9).getDigit());
        assertEquals("Неправильный перевод в десятичную систему!", "15", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._10).getDigit());
        assertEquals("Неправильный перевод в двенадцатичную систему!", "13", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._12).getDigit());
        assertEquals("Неправильный перевод в шестнадцатеричную систему!", "f", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._16).getDigit());
    }

    @Test
    public void convertNumberFrom9NumerationSystemTest() {
        Number number = new Number(NumerationSystemType._9, "16");

        assertEquals("Неправильный перевод в двоичную систему!", "1111", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._2).getDigit());
        assertEquals("Неправильный перевод в троичную систему!", "120", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._3).getDigit());
        assertEquals("Неправильный перевод в четверичную систему!", "33", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._4).getDigit());
        assertEquals("Неправильный перевод в пятеричную систему!", "30", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._5).getDigit());
        assertEquals("Неправильный перевод в шестеричную систему!", "23", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._6).getDigit());
        assertEquals("Неправильный перевод в семеричную систему!", "21", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._7).getDigit());
        assertEquals("Неправильный перевод в восьмеричную систему!", "17", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._8).getDigit());
        assertEquals("Неправильный перевод в девятичную систему!", "16", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._9).getDigit());
        assertEquals("Неправильный перевод в десятичную систему!", "15", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._10).getDigit());
        assertEquals("Неправильный перевод в двенадцатичную систему!", "13", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._12).getDigit());
        assertEquals("Неправильный перевод в шестнадцатеричную систему!", "f", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._16).getDigit());
    }

    @Test
    public void convertNumberFrom10NumerationSystemTest() {
        Number number = new Number(NumerationSystemType._10, "15");

        assertEquals("Неправильный перевод в двоичную систему!", "1111", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._2).getDigit());
        assertEquals("Неправильный перевод в троичную систему!", "120", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._3).getDigit());
        assertEquals("Неправильный перевод в четверичную систему!", "33", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._4).getDigit());
        assertEquals("Неправильный перевод в пятеричную систему!", "30", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._5).getDigit());
        assertEquals("Неправильный перевод в шестеричную систему!", "23", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._6).getDigit());
        assertEquals("Неправильный перевод в семеричную систему!", "21", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._7).getDigit());
        assertEquals("Неправильный перевод в восьмеричную систему!", "17", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._8).getDigit());
        assertEquals("Неправильный перевод в девятичную систему!", "16", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._9).getDigit());
        assertEquals("Неправильный перевод в десятичную систему!", "15", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._10).getDigit());
        assertEquals("Неправильный перевод в двенадцатичную систему!", "13", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._12).getDigit());
        assertEquals("Неправильный перевод в шестнадцатеричную систему!", "f", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._16).getDigit());
    }

    @Test
    public void convertNumberFrom12NumerationSystemTest() {
        Number number = new Number(NumerationSystemType._12, "13");

        assertEquals("Неправильный перевод в двоичную систему!", "1111", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._2).getDigit());
        assertEquals("Неправильный перевод в троичную систему!", "120", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._3).getDigit());
        assertEquals("Неправильный перевод в четверичную систему!", "33", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._4).getDigit());
        assertEquals("Неправильный перевод в пятеричную систему!", "30", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._5).getDigit());
        assertEquals("Неправильный перевод в шестеричную систему!", "23", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._6).getDigit());
        assertEquals("Неправильный перевод в семеричную систему!", "21", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._7).getDigit());
        assertEquals("Неправильный перевод в восьмеричную систему!", "17", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._8).getDigit());
        assertEquals("Неправильный перевод в девятичную систему!", "16", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._9).getDigit());
        assertEquals("Неправильный перевод в десятичную систему!", "15", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._10).getDigit());
        assertEquals("Неправильный перевод в двенадцатичную систему!", "13", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._12).getDigit());
        assertEquals("Неправильный перевод в шестнадцатеричную систему!", "f", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._16).getDigit());
    }

    @Test
    public void convertNumberFrom16NumerationSystemTest() {
        Number number = new Number(NumerationSystemType._16, "f");

        assertEquals("Неправильный перевод в двоичную систему!", "1111", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._2).getDigit());
        assertEquals("Неправильный перевод в троичную систему!", "120", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._3).getDigit());
        assertEquals("Неправильный перевод в четверичную систему!", "33", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._4).getDigit());
        assertEquals("Неправильный перевод в пятеричную систему!", "30", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._5).getDigit());
        assertEquals("Неправильный перевод в шестеричную систему!", "23", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._6).getDigit());
        assertEquals("Неправильный перевод в семеричную систему!", "21", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._7).getDigit());
        assertEquals("Неправильный перевод в восьмеричную систему!", "17", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._8).getDigit());
        assertEquals("Неправильный перевод в девятичную систему!", "16", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._9).getDigit());
        assertEquals("Неправильный перевод в десятичную систему!", "15", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._10).getDigit());
        assertEquals("Неправильный перевод в двенадцатичную систему!", "13", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._12).getDigit());
        assertEquals("Неправильный перевод в шестнадцатеричную систему!", "f", Solution.convertNumberToOtherNumerationSystem(number, NumerationSystemType._16).getDigit());
    }
}