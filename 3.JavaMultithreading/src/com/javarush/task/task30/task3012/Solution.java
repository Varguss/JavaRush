package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayDeque;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(13);
    }

    public void createExpression(int number) {
        ArrayDeque<Integer> values = new ArrayDeque<>();

        StringBuilder builder = new StringBuilder(Integer.toString(number) + " =");

        do {
            values.offerLast(number % 3);

            if (number % 3 == 2)
                number++;
        } while((number /= 3) > 2);

        values.offerLast(number);

        int size = values.size();

        for (int i = 0; i < size - 1; i++) {
            int value = values.pollFirst();

            if (value == 2)
                builder.append(" - ").append(pow(3, i));
            if (value == 1)
                builder.append(" + ").append(pow(3, i));
        }

        int lastValue = values.pollFirst();

        if (lastValue == 2)
            builder.append(" - ").append(pow(3, size-1)).append(" + ").append(pow(3, size));
        if (lastValue == 1)
            builder.append(" + ").append(pow(3, size-1));

        System.out.println(builder.toString());
    }

    private static int pow(int number, int pow) {
        if (pow == 0)
            return 1;

        int startedValue = number;

        for (int i = 1; i < pow; i++)
            number *= startedValue;

        return number;
    }
}