package com.javarush.task.task13.task1317;

/* 
The weather is fine
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int max = 0; // максимальное кол-во повторов
        int count = 0; // счетчик повторов (для цикла)
        for(int i = 0; i < 10; i++) // заполнение
            list.add(Integer.parseInt(r.readLine()));
        for(int i = 1; i < list.size(); i++) // 0 игнорируем из-за условия ниже
        {
            if (list.get(i - 1).equals((list.get(i)))) // проверка на сходство
            {
                if (count == 0) // если первое сходство
                    count = 2; // два числа сразу
                else
                    count++; // если не первое, то еще одно сходство
            }
            else // если предыдущий элемент не равен следующему
            {
                if (count > max) // если счетчик больше максимума
                {
                    max = count; // присваивание максимуму значение счетчика
                    count = 0; // обнуление
                }
                else
                    count = 0; // или просто обнуление, если счетчик не больше максимума
            }
            if((i == 9) && (count > max)) // если последний круг цикла и счетчик больше максимума
                max = count; // присваивание максимуму значение счетчика
        }
        System.out.println(max); // выведение максимального кол-ва повторов на экран
    }
}
