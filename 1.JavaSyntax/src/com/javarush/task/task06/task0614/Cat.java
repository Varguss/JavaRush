package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<Cat>();

    public Cat() {
        cats.add(this);
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++)
        {
            Cat cat = new Cat();
        }
        printCats(cats);
    }

    public static void printCats(ArrayList<Cat> catList) {
        for(Cat a:catList)
        {
            System.out.println(a);
        }
    }
}
