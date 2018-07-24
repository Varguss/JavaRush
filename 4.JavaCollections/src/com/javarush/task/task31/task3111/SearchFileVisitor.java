package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private List<Path> foundFiles = new ArrayList<>();
    private String partOfName, partOfContent;
    private int minSize = -1, maxSize = -1;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        long size = Files.size(file);

        if (minSize != -1 && maxSize != -1) {
            if (size > minSize && size < maxSize) {
                if (partOfName != null && partOfContent != null) {
                    byte[] bytes = Files.readAllBytes(file);

                    if (file.getFileName().toString().contains(partOfName) && new String(bytes).contains(partOfContent))
                        foundFiles.add(file);
                } else if (partOfName != null) {
                    if (file.getFileName().toString().contains(partOfName))
                        foundFiles.add(file);
                } else if (partOfContent != null) {
                    byte[] bytes = Files.readAllBytes(file);

                    if (new String(bytes).contains(partOfContent))
                        foundFiles.add(file);
                } else {
                    foundFiles.add(file);
                }
            }
        } else if (minSize != -1) {
            if (size > minSize) {
                if (partOfName != null && partOfContent != null) {
                    byte[] bytes = Files.readAllBytes(file);

                    if (file.getFileName().toString().contains(partOfName) && new String(bytes).contains(partOfContent))
                        foundFiles.add(file);
                } else if (partOfName != null) {
                    if (file.getFileName().toString().contains(partOfName))
                        foundFiles.add(file);
                } else if (partOfContent != null) {
                    byte[] bytes = Files.readAllBytes(file);

                    if (new String(bytes).contains(partOfContent))
                        foundFiles.add(file);
                } else {
                    foundFiles.add(file);
                }
            }
        } else if (maxSize != -1) {
            if (size < maxSize) {
                if (partOfName != null && partOfContent != null) {
                    byte[] bytes = Files.readAllBytes(file);

                    if (file.getFileName().toString().contains(partOfName) && new String(bytes).contains(partOfContent))
                        foundFiles.add(file);
                } else if (partOfName != null) {
                    if (file.getFileName().toString().contains(partOfName))
                        foundFiles.add(file);
                } else if (partOfContent != null) {
                    byte[] bytes = Files.readAllBytes(file);

                    if (new String(bytes).contains(partOfContent))
                        foundFiles.add(file);
                } else {
                    foundFiles.add(file);
                }
            }
        } else {
            if (partOfName != null && partOfContent != null) {
                byte[] bytes = Files.readAllBytes(file);

                if (file.getFileName().toString().contains(partOfName) && new String(bytes).contains(partOfContent))
                    foundFiles.add(file);
            } else if (partOfName != null) {
                if (file.getFileName().toString().contains(partOfName))
                    foundFiles.add(file);
            } else if (partOfContent != null) {
                byte[] bytes = Files.readAllBytes(file);

                if (new String(bytes).contains(partOfContent))
                    foundFiles.add(file);
            }
        }


        return super.visitFile(file, attrs);
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
