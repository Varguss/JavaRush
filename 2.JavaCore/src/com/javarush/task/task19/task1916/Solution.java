package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        String file1 = "", file2 = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();
            file2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        ArrayList<String> content1 = new ArrayList<>();
        ArrayList<String> content2 = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {
            while(reader.ready())
                content1.add(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file2))) {
            while(reader.ready())
                content2.add(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int f1 = 0;
        int f2 = 0;

        while (f1 < content1.size() && f2 < content2.size()) {

            //Если значения равны
            if (content1.get(f1).equals(content2.get(f2))) {
                linesAddSAME(content1.get(f1));
                f1++;
                f2++;
            }
            //если в первом файле существует след.строка и эта след.строка равна текущей во втором файле
            else if (content1.size() > f1 + 1 && content1.get(f1 + 1).equals(content2.get(f2))) {
                linesAddREMOVED(content1.get(f1));
                f1++;
            }
            //если во втором файле существует след.строка и эта след.строка равна текущей в первом файле
            else if (content2.size() > f2 + 1 && content2.get(f2 + 1).equals(content1.get(f1))) {
                linesAddADDED(content2.get(f2));
                f2++;
            }

        }
        if (f1 < content1.size()) {
            linesAddREMOVED(content1.get(f1));
        }
        if (f2 < content2.size()) {
            linesAddADDED(content2.get(f2));
        }


        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i).type.toString() + " " + lines.get(i).line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

    public static void linesAddSAME (String line) {
        lines.add(new LineItem(Type.SAME, line));
    }

    public static void linesAddADDED (String line) {
        lines.add(new LineItem(Type.ADDED, line));
    }

    public static void linesAddREMOVED (String line) {
        lines.add(new LineItem(Type.REMOVED, line));
    }
}
