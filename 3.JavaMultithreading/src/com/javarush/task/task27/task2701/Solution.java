package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Избавляемся от меток
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
        for(int i = 0; i <= (string.length() - substring.length()); i++) {
            if(string.charAt(i) == substring.charAt(0)) {
                StringBuilder builder = new StringBuilder();
                for(int k = i, count = 0; count < substring.length(); k++, count++)
                    builder.append(string.charAt(k));

                if(builder.toString().equals(substring))
                    return true;
            }
        }

        return false;
    }
}

