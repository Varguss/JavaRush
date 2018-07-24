package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {


        Human grandfather1 = new Human("Vanya1", true, 90);
        Human grandfather2 = new Human("Vanya2", true, 90);
        Human grandmother1 = new Human("Vanya3", false, 90);
        Human grandmother2 = new Human("Vanya4", false, 90);
        Human father = new Human("Vanya5", true, 9, grandfather1, grandmother1);
        Human mother = new Human("Vanya6", false, 9, grandfather2, grandmother2);
        Human child1 = new Human("Vanya7", true, 9, father, mother);
        Human child2 = new Human("Vanya8", true, 9, father, mother);
        Human child3 = new Human("Vanya9", true, 9, father, mother);

        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }



        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















