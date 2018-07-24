package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getException(Enum<?> e) {
        if (e == null)
            return new IllegalArgumentException();

        String message = e.name().replace("_", " ").toLowerCase();
        String comment = Character.toUpperCase(message.charAt(0)) + message.substring(1);

        switch (e.getDeclaringClass().getSimpleName()) {
            case "ExceptionApplicationMessage":
                return new Exception(comment);
            case "ExceptionDBMessage":
                return new RuntimeException(comment);
            case "ExceptionUserMessage":
                return new Error(comment);
            default:
                return new IllegalArgumentException();
        }
    }
}
