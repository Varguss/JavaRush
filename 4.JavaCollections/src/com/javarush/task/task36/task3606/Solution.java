package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException, URISyntaxException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        Path packagePath = Paths.get(packageName);

        try {
            Files.walk(packagePath).forEach((packageEntry) -> {
                if (Files.isDirectory(packageEntry))
                    return;

                PathClassLoader pathClassLoader = new PathClassLoader(packageEntry);

                try {
                    Class<?> clazz = pathClassLoader.load();

                    if (clazz != null)
                        hiddenClasses.add(clazz);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        try {
            Optional<Class> clazzOptional = hiddenClasses.stream().filter((clazz) -> clazz.getSimpleName().toLowerCase().contains(key.toLowerCase())).findAny();

            if (clazzOptional.isPresent()) {
                Class<?> clazz = clazzOptional.get();

                Constructor<?> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);

                return (HiddenClass) constructor.newInstance();
            }
        } catch (Exception e) {

        }

        return null;
    }

    private static class PathClassLoader extends ClassLoader {
        private Path path;

        private PathClassLoader(Path path) {
            this.path = path;
        }

        public Class<?> load() throws ClassNotFoundException {
            if (!path.getFileName().toString().endsWith(".class"))
                return null;

            try {
                byte[] clazzBytes = Files.readAllBytes(path);
                return defineClass(null, clazzBytes, 0, clazzBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}

