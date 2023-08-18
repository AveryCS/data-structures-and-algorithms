package com.practice.recursionproblems.dynamicprogramming;
import java.util.*;
/**Problem statement:
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.

 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.


 Leetcode link: https://leetcode.com/problems/course-schedule/description/
 **/
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites.length < 1) {
            return true;
        }
        Map < Integer, List < Integer >> map = createMap(prerequisites);
        Map < Integer, Boolean > storedMap = new HashMap < > ();
        boolean[] set = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (containsCycle(map, i, set, storedMap)) {
                return false;
            }
            Arrays.fill(set, false);
        }
        return true;
    }

    public static boolean containsCycle(Map < Integer, List < Integer >> map, int course, boolean[] set, Map < Integer, Boolean > storedMap) {
        if (storedMap.containsKey(course)) {
            return storedMap.get(course);
        }
        if (!map.containsKey(course)) {
            return false;
        }

        if (set[course]) {
            return true;
        }

        set[course] = true;
        boolean result = false;

        for (int singleCourse: map.get(course)) {
            boolean hasCycle = containsCycle(map, singleCourse, set, storedMap);
            if (hasCycle) {
                storedMap.put(singleCourse, true);
                return true;
            }
        }
        storedMap.put(course, false);
        return result;
    }

    public static Map < Integer, List < Integer >> createMap(int[][] prerequisites) {
        Map < Integer, List < Integer >> map = new HashMap < > ();

        for (int[] nums: prerequisites) {
            int key = nums[1];
            if (!map.containsKey(key)) {
                map.put(key, List.of(nums[0]));
            } else {
                List < Integer > temp = new ArrayList < > (map.get(key));
                temp.add(nums[0]);
                map.put(key, temp);
            }
        }
        return map;
    }
}
