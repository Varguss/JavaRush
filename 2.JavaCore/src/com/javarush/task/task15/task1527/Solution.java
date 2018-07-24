package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.regex.*;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URL = reader.readLine();
        // http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo



        Pattern pattern = Pattern.compile("\\?([a-zA-z_]+)=?.*&?"); // паттерн для получения всего после ?
        Pattern splitPattern = Pattern.compile("&"); // паттерн для разделения полученного выше (lvl=15, view, name=Amigo и т.д.)
        Pattern innerSplitPattern = Pattern.compile("="); // паттерн для разделения полученного выше ( lvl и 15, view, name и Amigo)
        Pattern doublePattern = Pattern.compile("\\d+\\.\\d+"); // паттерн для проверки числа Double
        Pattern numberPattern = Pattern.compile("\\d+");

        Matcher matcher = pattern.matcher(URL);

        String[] parameters = null; // массив для сплита

        if(matcher.find())
            parameters = splitPattern.split(matcher.group().substring(1)); // matcher.group - для получения всего после ?, substring(1) - для исключения ? из строки.

        // В данном цикле выводятся названия всех параметров (name, lvl, view, obj и т.д.)
        String result = "";

            for (int i = 0; i < parameters.length; i++) {
                String[] inner = innerSplitPattern.split(parameters[i]);

                if(i == parameters.length-1 && !result.contains(inner[0]))
                    result+=inner[0];
                else if (!result.contains(inner[0]))
                    result+=inner[0] + " ";
            }

        System.out.println(result);

            //Pattern objP = Pattern.compile("^obj=");
        // В данном цикле ищется параметр obj, после чего сплит через "=" и отправка значения obj в метод alert после проверки на наличие точки и числа
            for (String s : parameters) {
                if (s.startsWith("obj=")) {
                    String[] obj = innerSplitPattern.split(s);
                    if (doublePattern.matcher(obj[1]).matches() || numberPattern.matcher(obj[1]).matches())
                        alert(Double.parseDouble(obj[1]));
                    else
                        alert(obj[1]);
                }
            }
        }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
