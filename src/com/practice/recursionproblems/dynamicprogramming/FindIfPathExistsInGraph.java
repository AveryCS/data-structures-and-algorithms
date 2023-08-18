package com.practice.recursionproblems.dynamicprogramming;
import java.util.*;
/**Problem statement:
 There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

 You want to determine if there is a valid path that exists from vertex source to vertex destination.

 Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

 Example 1:
 Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 Output: true
 Explanation: There are two paths from vertex 0 to vertex 2:
 - 0 → 1 → 2
 - 0 → 2

 Example 2:
 Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
 Output: false
 Explanation: There is no path from vertex 0 to vertex 5.

 Constraints:
 1 <= n <= 2 * 105
 0 <= edges.length <= 2 * 105
 edges[i].length == 2
 0 <= ui, vi <= n - 1
 ui != vi
 0 <= source, destination <= n - 1
 There are no duplicate edges.
 There are no self edges.

 Leetcode link: https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 **/
public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length < 1) {
            return source == destination;
        }
        Map < Integer, List < Integer >> map = createMap(edges);
        Set < Integer > set = new HashSet < > ();
        Map < Integer, Boolean > storedMap = new HashMap < > ();
        return canFind(map, source, destination, set, storedMap);
    }
    public static boolean canFind(Map < Integer, List < Integer >> map, int source, int destination, Set < Integer > set, Map < Integer, Boolean > storedMap) {
        if (storedMap.containsKey(source)) {
            return storedMap.get(source);
        }
        if (!map.containsKey(source)) {
            return false;
        }
        if (source == destination || map.get(source).contains(destination)) {
            return true;
        }
        if (set.contains(source)) {
            return false;
        }
        set.add(source);

        for (Integer number: map.get(source)) {
            if (canFind(map, number, destination, set, storedMap)) {
                storedMap.put(number, true);
                return true;
            }
        }
        storedMap.put(source, false);
        return false;
    }
    public static Map < Integer, List < Integer >> createMap(int[][] edges) {
        Map < Integer, List < Integer >> map = new HashMap < > ();
        for (int[] singleArr: edges) {
            addEdge(singleArr, map);
        }
        return map;
    }
    public static void addEdge(int[] singleArr, Map < Integer, List < Integer >> map) {
        int key = singleArr[0];
        int val = singleArr[1];

        if (!map.containsKey(key)) {
            map.put(key, List.of(val));
        } else {
            List < Integer > temp = new ArrayList(map.get(key));
            temp.add(val);
            map.put(key, temp);
        }
        //flip
        key = singleArr[1];
        val = singleArr[0];
        if (!map.containsKey(key)) {
            map.put(key, List.of(val));
        } else {
            List < Integer > temp = new ArrayList(map.get(key));
            temp.add(val);
            map.put(key, temp);
        }
    }
}
