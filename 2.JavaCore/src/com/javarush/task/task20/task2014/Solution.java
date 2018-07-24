package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws Exception {
        System.out.println(new Solution(4));
        File file = File.createTempFile("file_", "testfile");
        FileInputStream in = new FileInputStream(file);
        FileOutputStream out = new FileOutputStream(file);

        Solution savedObject = new Solution(25);

        ObjectOutputStream outObjStrm = new ObjectOutputStream(out);
        outObjStrm.writeObject(savedObject);

        Solution loadedObject = new Solution(30);
        ObjectInputStream inObjStrm = new ObjectInputStream(in);
        loadedObject = (Solution) inObjStrm.readObject();

        System.out.println(savedObject.string.equals(loadedObject.string));

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
