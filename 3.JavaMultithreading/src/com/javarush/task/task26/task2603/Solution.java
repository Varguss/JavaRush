package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        @SafeVarargs
        public CustomizedComparator(Comparator<T> ... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2)
        {
            int result = 0;
            for (Comparator<T> comparator : comparators)
            {
                result = comparator.compare(o1, o2);
                if (result != 0) break; //если аргументы равны, переходим к следующему компаратору (критерию сравнения), если разные возвращаем результат сравнения
            }
            return result;
        }
        /*
        public int compare(T o1, T o2) {
            int result = 0;

            for(int i = 0; i < comparators.length; i++)
                if(comparators[i].compare(o1, o2) != 0)
                    result = comparators[i].compare(o1, o2);

            return result;
        }
        */

    }
}
