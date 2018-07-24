package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Для записи текста в консоль.
     * @param message Текст, который будет выводиться в консоль.
     */
    public static void writeMessage(String message) {
        System.out.println(message);
    }


    /**
     * @throws StackOverflowError Возможно при огромном количество повторных вводов.
     * @return Считанное с консоли сообщение.
     */
    public static String readString() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            return readString();
        }

    }

    /**
     * @throws StackOverflowError Возможно при огромном количество повторных вводов.
     * @return Считанное с консоли число.
     */
    public static int readInt() {
        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException e){
            writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            return readInt();
        }
    }
}
