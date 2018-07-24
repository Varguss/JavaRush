package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");

        System.out.println(a1.length);
        System.out.println(a2.length);
    }

    public static int getRectangleCount(byte[][] a) {
        byte[][] copy = a.clone();

        boolean oneFound;

        int result = 0;

        do {
            oneFound = false;
            for (int i = 0; i < copy.length; i++) {
                for (int k = 0; k < copy.length; k++) {
                    if (copy[i][k] == 1) {
                        oneFound = true;
                        if (i == copy.length - 1 && k == copy.length - 1) {
                            result++;
                            copy[i][k] = 0;
                        } else if (i == copy.length - 1) {
                            for (int in = k; in < copy.length; in++)
                                if (copy[i][in] == 1)
                                    copy[i][in] = 0;
                                else {
                                    result++;
                                    break;
                                }
                        } else if (k == copy.length - 1) {
                            for (int in = i; in < copy.length; in++)
                                if (copy[in][k] == 1)
                                    copy[in][k] = 0;
                                else {
                                    result++;
                                    break;
                                }
                        } else {
                            for (int v = i; v < copy.length; ) {
                                for (int h = k; k < copy.length && v < copy.length; ) {
                                    if (copy[v][h] == 1) {
                                        copy[v][h] = 0;
                                        h++;
                                    } else {
                                        h = k;
                                        v++;
                                        if (v == copy.length || copy[v][h] == 0)
                                            break;
                                    }
                                }
                                if (v == copy.length || copy[v][k] == 0)
                                    break;
                            }

                            result++;
                        }
                    }
                }
            }
        } while (oneFound);

        return result;
    }
}
