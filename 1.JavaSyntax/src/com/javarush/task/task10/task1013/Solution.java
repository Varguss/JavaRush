package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name, surname, address, phone_number;
        private int age;
        private Human love;

        public Human(String name, String surname, String address, String phone_number, int age, Human love) {
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.phone_number = phone_number;
            this.age = age;
            this.love = love;
        }

        public Human(String name, String address, String phone_number, Human love) {
            this.name = name;
            this.address = address;
            this.phone_number = phone_number;
            this.love = love;
        }

        public Human(String name, int age, Human love) {

            this.name = name;
            this.age = age;
            this.love = love;
        }

        public Human(String name, Human love) {

            this.name = name;
            this.love = love;
        }

        public Human(String name, String surname, String address, String phone_number, Human love) {

            this.name = name;
            this.surname = surname;
            this.address = address;
            this.phone_number = phone_number;
            this.love = love;
        }

        public Human(String name, String surname, String address, String phone_number) {

            this.name = name;
            this.surname = surname;
            this.address = address;
            this.phone_number = phone_number;
        }

        public Human(String name, String surname, String address, String phone_number, int age) {

            this.name = name;
            this.surname = surname;
            this.address = address;
            this.phone_number = phone_number;
            this.age = age;
        }

        public Human(String name, String surname, String address) {

            this.name = name;
            this.surname = surname;
            this.address = address;
        }

        public Human(String name) {

            this.name = name;
        }

        public Human(String name, String surname) {

            this.name = name;
            this.surname = surname;
        }
    }
}
