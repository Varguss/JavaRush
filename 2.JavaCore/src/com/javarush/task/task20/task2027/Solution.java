package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        for(Word w : detectAllWords(crossword, "home", "same"))
            System.out.println(w);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();

        int crosswordWidth = crossword[0].length;


        for (String word : words) {
            char[] symbols = word.toCharArray();
            List<Position> possibleStartPositions = new ArrayList<>();
            List<Position> possibleEndPositions = new ArrayList<>();
            List<Pair> possiblePairs = new ArrayList<>();

            for (int i = 0; i < crossword.length; i++) {
                for (int k = 0; k < crosswordWidth; k++) {
                    if (crossword[i][k] == symbols[0])
                        possibleStartPositions.add(new Position(k, i));
                    if (crossword[i][k] == symbols[symbols.length - 1])
                        possibleEndPositions.add(new Position(k, i));
                }
            }

            for (Position start : possibleStartPositions) {
                for (Position end : possibleEndPositions) {
                    if (getDistance(start, end) == word.length() - 1 || (getDistance(start, end) > (((word.length() - 1) * Math.sqrt(2)) - 0.000000000001) && getDistance(start, end) < (((word.length() - 1) * Math.sqrt(2)) + 0.000000000001))) {
                        possiblePairs.add(new Pair(start, end, word));
                    }
                }
            }

            if (possiblePairs.size() == 1) {
                list.add(possiblePairs.get(0).createWord());
            } else {
                for (Pair p : possiblePairs) {
                    StringBuilder content = new StringBuilder();
                    //System.out.println(String.format("ENTERED: %s - (%d, %d) - (%d, %d)", p.getContent(), p.getStart().getX(), p.getStart().getY(), p.getEnd().getX(), p.getEnd().getY()));
                    try {
                        if (p.getStart().getX() == p.getEnd().getX()) {
                            if (p.getStart().getY() < p.getEnd().getY()) {
                                for (int i = p.getStart().getY(); i <= p.getEnd().getY(); i++) {
                                    content.append((char) crossword[i][p.getStart().getX()]);
                                }
                            } else {
                                for (int i = p.getStart().getY(); i >= p.getEnd().getY(); i--) {
                                    content.append((char) crossword[i][p.getStart().getX()]);
                                }
                            }
                        } else if (p.getStart().getY() == p.getEnd().getY()) {
                            if (p.getStart().getX() < p.getEnd().getX()) {
                                for (int i = p.getStart().getX(); i <= p.getEnd().getX(); i++) {
                                    content.append((char) crossword[p.getStart().getY()][i]);
                                }
                            } else {
                                for (int i = p.getStart().getX(); i >= p.getEnd().getX(); i--) {
                                    content.append((char) crossword[p.getStart().getY()][i]);
                                }
                            }
                        } else {
                            if (p.getStart().getX() < p.getEnd().getX()) {
                                if (p.getStart().getY() < p.getEnd().getY()) {
                                    if((p.getEnd().getX() - p.getStart().getX() != p.getContent().length()-1) || (p.getEnd().getY() - p.getStart().getY() != p.getContent().length()-1))
                                        continue;
                                    for (int i = 0, x = p.getStart().getX(), y = p.getStart().getY(); i < p.getContent().length(); i++, x++, y++) {
                                        content.append((char) crossword[y][x]);
                                    }
                                } else {
                                    if((p.getEnd().getX() - p.getStart().getX() != p.getContent().length()-1) || (p.getStart().getY() - p.getEnd().getY() != p.getContent().length()-1))
                                        continue;
                                    for (int i = 0, x = p.getStart().getX(), y = p.getStart().getY(); i < p.getContent().length(); i++, x++, y--) {
                                        content.append((char) crossword[y][x]);
                                    }
                                }
                            } else {
                                if (p.getStart().getY() < p.getEnd().getY()) {
                                    if((p.getStart().getX() - p.getEnd().getX() != p.getContent().length()-1) || (p.getEnd().getY() - p.getStart().getY() != p.getContent().length()-1))
                                        continue;
                                    for (int i = 0, x = p.getStart().getX(), y = p.getStart().getY(); i < p.getContent().length(); i++, x--, y++) {
                                        content.append((char) crossword[y][x]);
                                    }
                                } else {
                                    if((p.getStart().getX() - p.getEnd().getX() != p.getContent().length()-1) || (p.getStart().getY() - p.getEnd().getY() != p.getContent().length()-1))
                                        continue;
                                    for (int i = 0, x = p.getStart().getX(), y = p.getStart().getY(); i < p.getContent().length(); i++, x--, y--) {
                                        content.append((char) crossword[y][x]);
                                    }
                                }
                            }
                        }

                        if (content.toString().equals(p.content)) {
                            list.add(p.createWord());
                            break; // закомментировать, если нужны повторы
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                }
            }
        }

        return list;
    }

    private static double getDistance(Position one, Position two) {
        return Math.sqrt(Math.pow((one.getX() - two.getX()), 2) + Math.pow((one.getY() - two.getY()), 2));
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }

    public static class Position {
        private int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static class Pair {
        private Position start, end;
        private String content;

        public Pair(Position start, Position end, String content) {
            this.start = start;
            this.end = end;
            this.content = content;
        }

        public Position getStart() {
            return start;
        }

        public Position getEnd() {
            return end;
        }

        public String getContent() {
            return content;
        }

        public Word createWord() {
            Word result = new Word(this.getContent());
            result.setStartPoint(this.getStart().getX(), this.getStart().getY());
            result.setEndPoint(this.getEnd().getX(), this.getEnd().getY());
            return result;
        }
    }
}