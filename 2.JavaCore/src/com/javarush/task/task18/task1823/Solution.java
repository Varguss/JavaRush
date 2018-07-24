package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String enter = "";

        do {
            try {
                enter = reader.readLine();
                if(!enter.equals("exit"))
                    new ReadThread(enter).start();
            } catch (IOException e) {
                System.out.println("Enter again.");
            }
        } while(!enter.equals("exit"));

        //for(Map.Entry<String, Integer> entry : resultMap.entrySet())
        //    System.out.println(entry.getKey() + " : " + entry.getValue() + " (" + (char)((int) entry.getValue()) + ")");
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run() {
            try (FileInputStream stream = new FileInputStream(this.fileName)) {
                Map<Byte, Integer> map = new HashMap<>();

                while(stream.available() > 0) {
                    byte b = (byte) stream.read();
                    if(map.containsKey(b))
                        map.put(b, map.get(b) + 1);
                    else
                        map.put(b, 1);
                }

                ArrayList<Byte> bytes = new ArrayList<>();

                int b = 0, c = 0;

                for(Map.Entry<Byte, Integer> entry : map.entrySet()) {
                    if(c < entry.getValue()) {
                        c = entry.getValue();
                        b = entry.getKey();
                    }
                }

                resultMap.put(this.fileName, b);
            } catch (FileNotFoundException e) {
                System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
