package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream stream = new FileInputStream(r.readLine());
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            ArrayList<Integer> list = new ArrayList<Integer>();
            try
            {
                String line = "";
                while ((line = reader.readLine()) != null)
                    if (!line.equals(""))
                        list.add(Integer.parseInt(line));

                ArrayList<Integer> external = new ArrayList<Integer>(list);

                for (Integer a : external)
                    if (a % 2 != 0)
                        list.remove(a);

                Collections.sort(list);
                for (Integer a : list)
                    System.out.println(a);

                stream.close();
                r.close();
                reader.close();
            }
            catch (IOException a)
            {
                try
                {
                    stream.close();
                    r.close();
                    reader.close();
                }
                catch (IOException b)
                {

                }
            }
    }
}
