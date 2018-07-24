package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {

        Set<Cat> cats = createCats();

        cats.remove(new Cat());                                                      //напишите тут ваш код. step 3 - пункт 3

        printCats(cats);
    }

    public static Set createCats() {

        Set<Cat> cats = new HashSet<Cat>();
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());
        //напишите тут ваш код. step 2 - пункт 2
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        for(Cat x:cats){
            System.out.println(x);
        }                                                                                       // step 4 - пункт 4
    }

    public static class Cat {                                                       // step1 Создаём class кота

    }
}
