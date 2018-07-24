package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {
    private static Map<Character, Integer> romanValues = new HashMap<>();

    // 1 - I, 5 - V, 10 - X, 50 - L, 100 - C, 500 - D и 1000 - M
    static {
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int result = 0;

        List<Integer> arrayList = new ArrayList<>();
        s.chars().forEachOrdered((character) -> arrayList.add(romanValues.get((char)character)));

        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (i == arrayList.size() - 1) {
                result += arrayList.get(i);
                continue;
            }

            if (arrayList.get(i) < arrayList.get(i+1))
                result -= arrayList.get(i);
            else
                result += arrayList.get(i);
        }

        return result;
    }
}
