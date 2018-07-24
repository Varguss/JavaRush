package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> content = new ArrayList<>();
        String fileName = reader.readLine();
        reader.close();

        readAllLines(fileName, content);

        switch(args[0]) {
            case "-u": {
                int id = Integer.parseInt(args[1]);
                int selectedLine = findLine(id, content);

                if(selectedLine == -1)
                    break;

                content.set(selectedLine-1, String.format("%-8s%-30s%-8s%-4s",
                        Integer.toString(id).length() > 8 ? Integer.toString(id).substring(0, 8) : Integer.toString(id),
                        args[2].length() > 30 ? args[2].substring(0, 30) : args[2],
                        args[3].length() > 8 ? args[3].substring(0, 8) : args[3],
                        args[4].length() > 4 ? args[4].substring(0, 4) : args[4]));
                PrintWriter writer = new PrintWriter(fileName);
                for(int i = 0; i < content.size(); i++)
                    if(i != content.size() -1)
                        writer.println(content.get(i));
                    else
                        writer.print(content.get(i));
                writer.close();
            } break;

            case "-d": {
                int id = Integer.parseInt(args[1]);
                int selectedLine = findLine(id, content);

                if(selectedLine == -1)
                    break;

                content.remove(selectedLine-1);
                PrintWriter writer = new PrintWriter(fileName);
                for(int i = 0; i < content.size(); i++)
                    if(i != content.size() -1)
                        writer.println(content.get(i));
                    else
                        writer.print(content.get(i));
                writer.close();
            } break;
        }
    }

    private static void readAllLines(String fileName, ArrayList<String> content) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while(reader.ready())
            content.add(reader.readLine());

        reader.close();
    }

    private static int findLine(int id, ArrayList<String> content) {
        int line = 1;

        for(String s : content) {
            if(Integer.parseInt(s.substring(0, 8).trim()) == id)
                return line;
            line++;
        }

        return -1;
    }
}
