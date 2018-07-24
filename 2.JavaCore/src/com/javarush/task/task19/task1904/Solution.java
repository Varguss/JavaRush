package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }


        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();
            String parts[] = line.split(" ");
            SimpleDateFormat format = new SimpleDateFormat("dd MM y");
            Date date = null;

            try {
                date = format.parse(parts[3] + " " + parts[4] + " " + parts[5]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return new Person(parts[1], parts[2], parts[0], date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
