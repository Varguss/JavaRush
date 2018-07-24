package com.myownterritory.tests1;

import java.io.BufferedReader;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Created by user on 26.06.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Car car = new Car();
        Car.Door door = car.new Door();


    }

    public static class Car {
        int width, height;

        public class Door {
            int width, height;

            public void setHeight(int height) {
                this.height = height;
            }

            public int getHeight() {
                if (height != 0)
                    return this.height;
                else
                    return (int) (Car.this.height * 0.8);
            }
        }
    }

}
