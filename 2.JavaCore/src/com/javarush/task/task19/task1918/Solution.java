package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        ArrayList<Index> indexes = new ArrayList<>();

        StringBuilder content = new StringBuilder();

        BufferedReader f = new BufferedReader(new FileReader(file));
        while(f.ready())
            content.append(f.readLine());
        f.close();

        int index = 0;

        while(index != -1) {
            boolean isOpen = false;

            if(content.indexOf(String.format("<%s", args[0]), index + args[0].length()) < content.indexOf(String.format("</%s>", args[0]), index + args[0].length()) && !(content.indexOf(String.format("<%s", args[0]), index + args[0].length()) == -1)) {
                isOpen = true;
                index = content.indexOf(String.format("<%s", args[0]), index + args[0].length());
            } else {
                index = content.indexOf(String.format("</%s>", args[0]), index + args[0].length());
            }

            if(index != -1)
                indexes.add(new Index(index, isOpen));
        }

        ArrayList<Tag> tags = new ArrayList<>();

        for(int i = 0; i < indexes.size(); i++) {
            if(!indexes.get(i).isOpen) continue;

            int bonus = 0;
            for(int k = i+1; k < indexes.size(); k++) {
                if(!indexes.get(k).isOpen)
                    break;
                else
                    bonus += 2;
            }

            tags.add(new Tag(indexes.get(i).value, indexes.get(i+1+bonus).value + args[0].length() + 2));
        }

        for(Tag tag : tags) {
            System.out.println(content.substring(tag.open_index, tag.close_index + 1));
        }
    }

    static class Tag {
        int open_index, close_index;

        Tag(int open_index, int close_index) {
            this.open_index = open_index;
            this.close_index = close_index;
        }
    }

    static class Index {
        boolean isOpen;
        int value;

        Index(int value, boolean isOpen) {
            this.value = value;
            this.isOpen = isOpen;
        }
    }
}
