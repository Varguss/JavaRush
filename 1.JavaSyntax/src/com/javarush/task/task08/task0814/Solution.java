package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < 20; i++)
            set.add(i);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        ArrayList<Integer> list = new ArrayList<Integer>(set);
        for(int i = list.size()-1; i >=0; i--)
            if(list.get(i)>10)
                list.remove(i);
        set = new HashSet<Integer>(list);
        return set;
    }

    public static void main(String[] args) {
        removeAllNumbersMoreThan10(createSet());
    }
}
