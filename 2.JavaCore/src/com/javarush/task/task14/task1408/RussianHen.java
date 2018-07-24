package com.javarush.task.task14.task1408;

/**
 * Created by user on 22.06.2017.
 */
public class RussianHen extends Hen {
    static String country = "Russia";
    public int getCountOfEggsPerMonth() {
        return 75;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + country + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}