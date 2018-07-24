package com.javarush.task.task18.task1814;

public class UnsupportedFileNameException extends Exception {
    public UnsupportedFileNameException() {
        super("Поддержка только .txt файлов.");
    }
}
