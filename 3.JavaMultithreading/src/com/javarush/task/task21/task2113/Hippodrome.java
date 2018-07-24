package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Rainbow", 3, 0));
        horses.add(new Horse("Jumper", 3, 0));
        horses.add(new Horse("Runner", 3, 0));
        game = new Hippodrome(horses);

        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return this.horses;
    }

    Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    void print() {
        horses.forEach(Horse::print);
        System.out.print("\n\n\n\n\n\n\n\n\n\n");
    }

    void move() {
        horses.forEach(Horse::move);
    }
    
    void run() throws InterruptedException {
        for(int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        double distance = 0;

        Horse winner = null;

        for(Horse s : horses)
            if(s.getDistance() > distance) {
            winner = s;
            distance = s.getDistance();
        }

        return winner;
    }

    public void printWinner() {
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }
}
