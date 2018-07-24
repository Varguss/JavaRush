package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        String fileName = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder text = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while(reader.ready()) {
                if (text.length() > 0)
                    text.append(" ");
                text.append(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder result = getLine(text.toString().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
          if(words.length == 0)
              return new StringBuilder();

          StringBuilder result = new StringBuilder(words[0]);

          for(int n = 0; n < words.length - 1; n++) {
              for (int i = 1; i < words.length; i++) {
                  if (result.toString().contains(words[i]))
                      continue;

                  if (Character.toLowerCase(result.charAt(0)) == Character.toLowerCase(words[i].charAt(words[i].length() - 1))) {
                      result.insert(0, words[i] + " ");
                      break;
                  }

                  if (Character.toLowerCase(result.charAt(result.length() - 1)) == Character.toLowerCase(words[i].charAt(0))) {
                      result.insert(result.length(), " " + words[i]);
                      break;
                  }
              }
          }


          for(int i = 1; i < words.length; i++) {
              if(!result.toString().contains(words[i]))
                  result.append(" ").append(words[i]);
          }

          return result;
    }
}
