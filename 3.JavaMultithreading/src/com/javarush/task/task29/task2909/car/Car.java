package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    public static final int TRUCK = 0;
    public static final int SEDAN = 1;
    public static final int CABRIOLET = 2;


    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private boolean driverAvailable;
    private int numberOfPassengers;
    private int type;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    protected Car(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers) {
        switch(type) {
            case TRUCK: {
                return new Truck(numberOfPassengers);
            }
            case SEDAN: {
                return new Sedan(numberOfPassengers);
            }
            case CABRIOLET: {
                return new Cabriolet(numberOfPassengers);
            }
            default: {
                return null;
            }
        }
    }

    private boolean isSummer(Date date , Date summerStart, Date summerEnd) {
        return date.after(summerStart) && date.before(summerEnd);
    }

    private double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    private double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception("NEGATIVE NUMBER OF FUEL.");
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        if(isSummer(date, SummerStart, SummerEnd))
            return getSummerConsumption(length);
        else
            return getWinterConsumption(length);
    }

    private boolean canPassengersBeTransferred() {
        return isDriverAvailable() && (fuel > 0);
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if(!canPassengersBeTransferred())
            return 0;

        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0)
            fastenPassengersBelts();

        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();
}