package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    /*
    -c name1 sex1 bd1 name2 sex2 bd2 ...
    -u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
    -d id1 id2 id3 id4 ...
    -i id1 id2 id3 id4 ...
     */
    public static void main(String[] args) {
        try {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 3)
                            create(args[i], args[i + 1], args[i + 2]);
                    }
                    break;
                case "-u":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 4)
                            update(Integer.parseInt(args[i]), args[i + 1], args[i + 2], args[i + 3]);
                    }
                    break;
                case "-d":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++)
                            delete(Integer.parseInt(args[i]));
                    }
                    break;
                case "-i":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++)
                            show(Integer.parseInt(args[i]));
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void create(String name, String sex, String bd) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
        if (sex.equals("м"))
            allPeople.add(Person.createMale(name, format.parse(bd)));
        else
            allPeople.add(Person.createFemale(name, format.parse(bd)));
        System.out.println(allPeople.size() - 1);
    }

    private static void update(int id, String name, String sex, String bd) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
        Person person = allPeople.get(id);
        person.setName(name);
        if (sex.equals("м"))
            person.setSex(Sex.MALE);
        else
            person.setSex(Sex.FEMALE);
        person.setBirthDay(format.parse(bd));
    }

    private static void delete(int id) {
        Person person = allPeople.get(id);
        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);
    }

    private static void show(int id) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
        Person person = allPeople.get(id);
        System.out.println(String.format("%s %s %s", person.getName(), person.getSex() == Sex.MALE ? "м" : "ж", format.format(person.getBirthDay())));
    }
}
