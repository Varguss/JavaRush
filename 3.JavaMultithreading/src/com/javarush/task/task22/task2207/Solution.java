package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        String fileName = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while(reader.ready()) {
                String[] currentWords = reader.readLine().split(" ");
                words.addAll(Arrays.asList(currentWords));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < words.size(); i++) {
            for(int k = i+1; k < words.size(); k++) {
                if(words.get(i).equals(new StringBuilder(words.get(k)).reverse().toString())) {
                    result.add(new Pair(words.get(i), words.get(k)));
                    words.remove(k--);
                    words.remove(i--);
                    break;
                }
            }
        }

        result.forEach(System.out::println);

//        рот тор
//        о о
//        тот тот
//        торт трот
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
            
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }

}
