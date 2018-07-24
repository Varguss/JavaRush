package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        try {
            if (args[0].equals("-c"))
                if (args[2].equals("м"))
                    create(args[1], Sex.MALE, args[3]);
                else if (args[2].equals("ж"))
                    create(args[1], Sex.FEMALE, args[3]);
            if (args[0].equals("-u"))
                if (args[3].equals("м"))
                    update(Integer.parseInt(args[1]), args[2], Sex.MALE, args[4]);
                else if (args[3].equals("ж"))
                    update(Integer.parseInt(args[1]), args[2], Sex.FEMALE, args[4]);
            if (args[0].equals("-d"))
                delete(Integer.parseInt(args[1]));
            if (args[0].equals("-i"))
                show(Integer.parseInt(args[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void create(String name, Sex sex, String bd) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
        if(sex == Sex.MALE)
            allPeople.add(Person.createMale(name, format.parse(bd)));
        else
            allPeople.add(Person.createFemale(name, format.parse(bd)));
        System.out.println(allPeople.size() - 1);
    }

    private static void update(int id, String name, Sex sex, String bd) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
        Person person = allPeople.get(id);
        person.setName(name);
        person.setSex(sex);
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
