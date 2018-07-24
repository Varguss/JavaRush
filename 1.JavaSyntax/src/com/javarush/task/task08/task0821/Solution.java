package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Степан");
        map.put("Иванов", "Андрей");
        map.put("Бендера", "Иосиф");
        map.put("Лейтенант", "Сузульцев");
        map.put("Ядренный", "Фаршик");
        map.put("Остап", "Синус");
        map.put("Косинус", "Максим");
        map.put("Катангенс", "Прогрессия");
        map.put("Бабочка", "Максим");
        map.put("Колонка", "Жульничество");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
