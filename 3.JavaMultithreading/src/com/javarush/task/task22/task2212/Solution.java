package com.javarush.task.task22.task2212;

import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber == null)
            return false;
        Pattern pattern = Pattern.compile("^(\\+[0-9]{2})?\\(?[0-9]{3}\\)?[0-9]{3}-?[0-9]{2}-?[0-9]{2}$");
        return telNumber.matches(pattern.pattern());
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
    }

//            +380501234567 - true
//            +38(050)1234567 - true
//            +38050123-45-67 - true
//            050123-4567 - true
//            +38)050(1234567 - false
//            +38(050)1-23-45-6-7 - false
//            050ххх4567 - false
//            050123456 - false
//            (0)501234567 - false
}
