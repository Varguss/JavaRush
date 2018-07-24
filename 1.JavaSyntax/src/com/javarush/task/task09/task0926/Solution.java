package com.javarush.task.task09.task0926;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        int[] a1 = new int[5], a2 = new int[2], a3 = new int[4], a4 = new int[7], a5 = new int[0];
        Arrays.fill(a1,5);
        Arrays.fill(a2, 2);
        Arrays.fill(a3, 4);
        Arrays.fill(a4, 7);

        ArrayList<int[]> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);

        return list;
    }

    /*
    Список из массивов чисел
    Создать список, элементами которого будут массивы чисел.
    Добавить в список пять объектов-массивов длиной 5, 2, 4, 7, 0 соответственно.
    Заполнить массивы любыми данными и вывести их на экран.
     */
    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
