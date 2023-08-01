package com.practice.miscellaneous;

import java.util.*;

/**
 * Problem statement:
 * Create a map with Integers as the key, and a list of integers as a value, and perform a level order traversal on it.
 * <p>
 * This is a problem I created for myself, in order to be able to do a level order traversal on a map
 **/
public class LevelOrderTraversalOnMap {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, List.of(3, 2, 4));
        map.put(2, List.of(7, 5));

        breadthFirstSearch(map, 1);
    }

    public static void breadthFirstSearch(Map<Integer, List<Integer>> map, int begin) {
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        q.add(begin);
        visited.add(begin);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                System.out.println(q.peek());
                addUnivsitedNeighborsToSetAndQueue(q.peek(), map, visited, q);
                q.remove();
            }
            System.out.println("----------");
        }
    }

    public static void addUnivsitedNeighborsToSetAndQueue(int number, Map<Integer, List<Integer>> map, Set<Integer> visited, Queue<Integer> q) {
        if (!map.containsKey(number)) {
            return;
        }

        for (int i : map.get(number)) {
            if (!visited.contains(i)) {
                q.add(i);
                visited.add(i);
            }
        }
    }
}
