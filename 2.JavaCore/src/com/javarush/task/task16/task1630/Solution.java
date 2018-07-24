package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private ArrayList<String> content = new ArrayList<String>();

        public void setFileName(String fullFillName) {
            this.fileName = fullFillName;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                while(reader.ready())
                    content.add(reader.readLine());
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String getFileContent() {
            StringBuilder result = new StringBuilder("");
            for(String s : content)
                result.append(s).append(" ");
            return result.toString().trim();
        }
    }
}
