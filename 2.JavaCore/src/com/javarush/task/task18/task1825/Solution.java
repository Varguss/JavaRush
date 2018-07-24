package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    private static List<String> files = new ArrayList<>();
    private static List<Integer> indexes = new ArrayList<>();
    private static List<byte[]> buffers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        String fileFinal = "";

        if(!fileName.equals("end"))
            fileFinal = ejectFinalFileName(fileName);

        while(!fileName.equals("end")) {
            addFileToList(fileName);
            fileName = reader.readLine();
        }

        for(int i = 1; i <= indexes.size(); i++) {
            for(int k = 0; k < indexes.size(); k++) {
                if(i == indexes.get(k))
                    buffers.add(readBuffer(files.get(k)));
            }
        }

        if(!fileFinal.equals(""))
            writeBuffers(buffers, fileFinal);

        System.out.println(fileFinal);
        reader.close();
    }

    private static void addFileToList(String fileName) {
        String split[] = fileName.split("\\.");

        String part = split[split.length - 1];

        int number = Integer.parseInt(part.substring(part.indexOf('t') + 1, part.length()));

        System.out.println(fileName + ": #" + number);

        files.add(fileName);
        indexes.add(number);
    }

    private static byte[] readBuffer(String fileName) throws IOException {
        FileInputStream stream = new FileInputStream(fileName);
        byte[] result = new byte[stream.available()];

        stream.read(result);
        stream.close();

        return result;
    }

    private static String ejectFinalFileName(String simpleFileName) {
        String parts[] = simpleFileName.split("\\.");

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < parts.length - 2; i++) {
            result.append(parts[i]).append(".");
        }

        result.append(parts[parts.length - 2]);

        return result.toString();
    }

    private static void writeBuffers(List<byte[]> buffers, String file) throws IOException {
        FileOutputStream stream = new FileOutputStream(file);

        for(byte[] b : buffers)
            stream.write(b);

        stream.close();
    }
}
