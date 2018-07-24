package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> aClass;

    public Generator(Class<T> aClass) {
        this.aClass = aClass;
    }

    T newInstance() {
        try {
            return aClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
