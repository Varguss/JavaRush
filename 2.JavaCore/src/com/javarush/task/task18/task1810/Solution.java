package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        PrintStream console = System.out;
        console.print("Hello, world!");

        ByteArrayOutputStream s = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(s);
        ps.println("HELLLO!!!!");
    }
    public static class DownloadException extends Exception {
        public DownloadException() {
            super("МНЕ НУЖНО БОЛЬШЕ БАЙТ!!!");
        }
    }
}