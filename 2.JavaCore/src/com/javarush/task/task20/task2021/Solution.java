package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private Object readObject(ObjectInputStream in) throws NotSerializableException {
            throw new NotSerializableException("DON'T SERIALIZABLE!");
        }

        private Object writeObject(ObjectOutputStream out) throws NotSerializableException {
            throw new NotSerializableException("DON'T SERIALIZABLE!");
        }
    }

    public static void main(String[] args) {

    }
}
