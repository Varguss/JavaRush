package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/
import java.io.*;
import java.util.zip.ZipInputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();

        InputStream stream = new FileInputStream("d:/Музыка/song-bytecode.txt");
        OutputStream outStream = new FileOutputStream("d:/Музыка/song-bytecode.txt");

        while (stream.available() > 0)
        {
            int data = stream.read();
            outStream.write(data);
        }

        stream.close();
        outStream.close();
    }

    static class HenFactory {
        static Hen getHen(String country) {
            Hen hen = null;
            if(country.equals(RussianHen.country))
                hen = new RussianHen();
            if(country.equals(MoldovanHen.country))
                hen = new MoldovanHen();
            if(country.equals(UkrainianHen.country))
                hen = new UkrainianHen();
            if(country.equals(BelarusianHen.country))
                hen = new BelarusianHen();
            return hen;
        }
    }
}
