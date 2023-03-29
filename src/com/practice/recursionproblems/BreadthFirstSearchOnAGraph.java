import java.io.*;
import java.util.*;

/**
 *Problem statement: Create a hashmap representing a graph, where the key is an element in the graph, and the value is
 * the list of neighbors.
 *
 * After this, implement a breadth first search
 *
 *
 **/
package com.practice.recursionproblems;
public class BreadthFirstSearchOnAGraph {
    public static void main(String[] args) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        map.put(2, List.of(3, 0, 9));
        map.put(9, List.of(2));
        map.put(3, List.of(2, 7));
        map.put(0, List.of(2, 7));
        map.put(7, List.of(3, 0));
    }
}