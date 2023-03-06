package com.practice.miscellaneous;
import java.util.*;

/**
 * Implement a level order traversal/breadth first search on 2D matric
 **/
public class BreadthFirstSearch {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        bfs(nums);
    }
    public static void bfs(int[][] nums) {
        Queue < List < Integer >> coordinates = new ArrayDeque < > ();
        Set < List < Integer >> visitedSet = new HashSet < > ();
        coordinates.add(List.of(0, 0));
        visitedSet.add(List.of(0, 0));

        int size = coordinates.size();
        int row = 0;
        int col = 0;
        System.out.println(nums[coordinates.peek().get(0)][coordinates.peek().get(1)]);
        System.out.println("---------------");
        while (!coordinates.isEmpty()) {
            size = coordinates.size();
            for (int i = 0; i < size; i++) {
                row = coordinates.peek().get(0);
                col = coordinates.peek().get(1);

                addNeighbors(coordinates, visitedSet, row, col, nums);
                coordinates.remove();
            }

            for (List < Integer > k: coordinates) {
                System.out.println(nums[k.get(0)][k.get(1)]);
            }
            System.out.println("---------------");

        }
    }
    public static void addNeighbors(Queue < List < Integer >> coordinates, Set < List < Integer >> visitedSet, int row, int col, int[][] nums) {
        int height = nums.length;
        int length = nums[0].length;
        //check down
        if (row + 1 < height && !visitedSet.contains(List.of(row + 1, col))) {
            coordinates.add(List.of(row + 1, col));
            visitedSet.add(List.of(row + 1, col));
        }
        //check up
        if (row - 1 > -1 && !visitedSet.contains(List.of(row - 1, col))) {
            coordinates.add(List.of(row - 1, col));
            visitedSet.add(List.of(row - 1, col));
        }
        //check left
        if (col - 1 > -1 && !visitedSet.contains(List.of(col - 1, row))) {
            coordinates.add(List.of(row, col - 1));
            visitedSet.add(List.of(row, col - 1));
        }
        //check right
        if (col + 1 < length && !visitedSet.contains(List.of(row, col + 1))) {
            coordinates.add(List.of(row, col + 1));
            visitedSet.add(List.of(row, col + 1));
        }

    }
}