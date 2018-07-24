package com.javarush.task.task08.task0817;

import javax.swing.text.DefaultEditorKit;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Class<?>[] classes = new Class[] { Runnable.class, Callable.class };

        Object proxy = Proxy.newProxyInstance(null, classes, new StopProxy("Hi"));

    }

    public static class StopProxy implements InvocationHandler {
        private String name;

        public StopProxy(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object invoke(Object proxy, Method m, Object[] args) throws Exception {
            System.out.println(name);
            return m.invoke(name, args);
        }
    }
}
