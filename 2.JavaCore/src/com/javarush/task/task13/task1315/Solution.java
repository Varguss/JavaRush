package com.javarush.task.task13.task1315;

/* 
Том, Джерри и Спайк
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException
    {
        InputStream inStream = new FileInputStream("d:/Музыка/monster.mp3");
        OutputStream outStream = new FileOutputStream("d:/Музыка/wrongsideofheaven - копия.mp3");

        while (inStream.available() > 0)
        {
            byte data = (byte) inStream.read(); //читаем один байт из потока для чтения
            outStream.write(data); //записываем прочитанный байт в другой поток.
        }

        inStream.close(); //закрываем потоки
        outStream.close();
    }
}