package com.javarush.task.task36.task3611;

import java.util.*;

/* 
Сколько у человека потенциальных друзей?
*/

public class Solution {
    private boolean[][] humansRelationships;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.humansRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);                              //expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           //expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        final Set<Integer> set = new HashSet<>(getFriends(index, index));

        for (int i = 1; i < deep; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.addAll(set);

            queue.forEach((entry) -> set.addAll(getFriends(entry, index)));
        }

        return set;
    }

    private Set<Integer> getFriends(int index, int excluding) {
        Set<Integer> set = new HashSet<>();

        for (int i = index+1; i < humansRelationships.length; i++)
            if (humansRelationships[i][index] && i != excluding)
                set.add(i);

        for (int i = 0; i < index; i++) {
            if (humansRelationships[index][i] && i != excluding)
                set.add(i);
        }

        return set;
    }

    //remove people from set, with which you have already had relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humansRelationships.length; i++) {
            if ((i < index) && (index < humansRelationships.length) && humansRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humansRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    //return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                  //0
                {true,  true},                                                           //1
                {false, true,  true},                                                    //2
                {false, false, false,  true},                                            //3
                {true,  true,  false,  true,  true},                                     //4
                {true,  false, true,   false, false, true},                              //5
                {false, false, false,  false, false, true,  true},                       //6
                {false, false, false,  true,  false, false, false, true}                 //7
        };
    }
}