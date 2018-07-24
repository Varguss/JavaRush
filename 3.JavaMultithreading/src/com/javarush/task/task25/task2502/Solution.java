package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws IllegalArgumentException {
            String[] wheelsSetup = loadWheelNamesFromDB();
            if(wheelsSetup.length > 4 || wheelsSetup.length < 4)
                throw new IllegalArgumentException("There can be only 4 wheels.");

            wheels = new ArrayList<>();

            for(String setup : wheelsSetup)
                wheels.add(Wheel.valueOf(setup));
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
    }
}
