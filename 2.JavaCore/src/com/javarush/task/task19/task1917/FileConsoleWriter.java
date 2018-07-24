package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public static void main(String[] args) throws IOException {
//        FileConsoleWriter writer = new FileConsoleWriter("d:/file1.txt");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s = "";
//
//        while(!s.equals("end")) {
//            s = reader.readLine();
//            writer.write(s);
//        }
//
//        writer.close();
    }

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public void write(int c) throws IOException {
        System.out.println(c);

        fileWriter.write(c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        StringBuilder string = new StringBuilder(len);

        for(int i = 0, k = off; i < len; i++, k++)
            string.append(cbuf[k]);

        System.out.println(string);

        fileWriter.write(cbuf, off, len);
    }

    public void write(String str, int off, int len) throws IOException {
        char[] chars = str.toCharArray();

        StringBuilder string = new StringBuilder(len);

        for(int i = 0, k = off; i < len; i++, k++)
            string.append(chars[k]);

        System.out.println(string);

        fileWriter.write(str, off, len);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public void write(char[] cbuf) throws IOException {
        StringBuilder string = new StringBuilder(cbuf.length);

        for(char a : cbuf)
            string.append(a);

        System.out.println(string);
        fileWriter.write(cbuf);
    }

    public void write(String str) throws IOException {
        System.out.println(str);
        fileWriter.write(str);
    }
}
