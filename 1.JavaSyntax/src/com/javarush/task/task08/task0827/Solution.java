package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException, NotCorrectMonthException {
        System.out.println(isDateOdd("FEBRUARY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException, NotCorrectMonthException {
        Scanner scanner = new Scanner(date);
        String month = scanner.next();
        int day = scanner.nextInt();
        int year = scanner.nextInt();
        int monthNumber = -1;
        switch (month) {
            case "MAY": monthNumber = Calendar.MAY; break;
            case "FEBRUARY": monthNumber = Calendar.FEBRUARY; break;
            case "APRIL": monthNumber = Calendar.APRIL; break;
            case "AUGUST": monthNumber = Calendar.AUGUST; break;
            case "DECEMBER": monthNumber = Calendar.DECEMBER; break;
            case "JANUARY": monthNumber = Calendar.JANUARY; break;
            case "JULY": monthNumber = Calendar.JULY; break;
            case "JUNE": monthNumber = Calendar.JUNE; break;
            case "MARCH": monthNumber = Calendar.MARCH; break;
            case "NOVEMBER": monthNumber = Calendar.NOVEMBER; break;
            case "OCTOBER": monthNumber = Calendar.OCTOBER; break;
            case "SEPTEMBER": monthNumber = Calendar.SEPTEMBER; break;
        }

        if(monthNumber==-1)
            throw new NotCorrectMonthException();

        //System.out.println(monthNumber);
        //System.out.println(month);
        Calendar calendar = new GregorianCalendar(year, monthNumber, day);
        return calendar.get(Calendar.DAY_OF_YEAR)%2!=0;
    }

    public static class NotCorrectMonthException extends Exception {
        public NotCorrectMonthException() {
            super("Not correct month. Please, enter right month.");
        }
    }
}
