package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]), resultFileAbsolutePath = new File(args[1]);
        final Set<File> files = new TreeSet<>(Comparator.comparing(File::getName));

        forEachInDirectory(path, files);

        File destination = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, destination);

        System.out.println(resultFileAbsolutePath.getAbsolutePath());
        FileOutputStream outputStream = new FileOutputStream(destination);
        for (File file : files) {
            byte[] bytes = Files.readAllBytes(file.toPath());

            outputStream.write(bytes);
            outputStream.write("\n".getBytes());
        }

        outputStream.close();
    }

    private static void forEachInDirectory(File directory, Set<File> files) {
        if (!directory.isDirectory())
            return;

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                if (file.length() <= 50)
                    files.add(file);
            } else {
                forEachInDirectory(file, files);
            }
        }
    }
}
