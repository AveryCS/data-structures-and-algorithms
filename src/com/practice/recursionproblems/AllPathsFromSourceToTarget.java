package com.practice.recursionproblems;
import java.util.*;
/**Problem statement:
 Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

 The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

 Example 1:
 Input: graph = [[1,2],[3],[3],[]]
 Output: [[0,1,3],[0,2,3]]
 Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

 Example 2:
 Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

 Constraints:
 n == graph.length
 2 <= n <= 15
 0 <= graph[i][j] < n
 graph[i][j] != i (i.e., there will be no self-loops).
 All the elements of graph[i] are unique.
 The input graph is guaranteed to be a DAG.

 Leetcode link: https://leetcode.com/problems/all-paths-from-source-to-target/description/
 **/
public class AllPathsFromSourceToTarget {
    public List < List < Integer >> allPathsSourceTarget(int[][] graph) {
        Map < Integer, List < Integer >> map = createMap(graph);
        Map < Integer, List < Integer >> pathMap = new HashMap < > ();
        int destination = graph.length - 1;
        List < Integer > tempList = new ArrayList < > ();
        List < List < Integer >> resultList = new ArrayList < > ();
        findPath(map, 0, destination, tempList, resultList);
        return resultList;

    }
    public static Map < Integer, List < Integer >> createMap(int[][] graph) {
        Map < Integer, List < Integer >> result = new HashMap < > ();

        int height = graph.length;

        for (int i = 0; i < height; i++) {
            int[] singleArr = graph[i];
            if (singleArr.length > 0) {
                List < Integer > tempList = createListFromArray(singleArr);
                result.put(i, tempList);
            }
        }
        return result;
    }
    public static List < Integer > createListFromArray(int[] singleArr) {
        List < Integer > result = new ArrayList < > ();

        for (int i: singleArr) {
            result.add(i);
        }
        return result;
    }
    public static void findPath(Map < Integer, List < Integer >> map, int number, int destination, List < Integer > tempList, List < List < Integer >> resultList) {

        tempList.add(number);
        if (number == destination) {
            resultList.add(new ArrayList < > (tempList));
            tempList.remove(tempList.size() - 1);
            return;
        }
        if (!map.containsKey(number)) {
            tempList.remove(tempList.size() - 1);
            return;
        }

        for (Integer i: map.get(number)) {
            findPath(map, i, destination, tempList, resultList);
        }
        tempList.remove(tempList.size() - 1);
        return;

    }
}
