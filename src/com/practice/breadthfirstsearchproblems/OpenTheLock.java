package com.practice.breadthfirstsearchproblems;
import java.util.*;
/**Problem statement:
 You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

 The lock initially starts at '0000', a string representing the state of the 4 wheels.

 You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

 Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.



 Example 1:

 Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 Output: 6
 Explanation:
 A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 because the wheels of the lock become stuck after the display becomes the dead end "0102".

 Constraints:

 1 <= deadends.length <= 500
 deadends[i].length == 4
 target.length == 4
 target will not be in the list deadends.
 target and deadends[i] consist of digits only.

 Leetcode link: https://leetcode.com/problems/open-the-lock/description/
 **/

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set < String > deadendSet = addDeadendsToSet(deadends);
        Queue < String > q = new ArrayDeque < > ();
        Set < String > visited = new HashSet < > ();

        if (deadendSet.contains("0000")) {
            return -1;
        }
        q.add("0000");
        visited.add("0000");
        int size = q.size();
        int count = 0;
        while (!q.isEmpty()) {
            size = q.size();

            for (int i = 0; i < size; i++) {

                if (q.peek().equals(target)) {
                    return count;
                }
                List < String > allNeighbors = findAllNeighbors(q.peek());
                addNonDeadEndAndNonVisitedNeighborsToQueue(allNeighbors, deadendSet, q, visited);
                addAllNeighborsToVisitedSet(allNeighbors, visited);
                q.remove();
            }
            count++;
        }
        return -1;
    }
    public static Set < String > addDeadendsToSet(String[] deadends) {
        Set < String > set = new HashSet < > ();
        for (String s: deadends) {
            set.add(s);
        }
        return set;
    }
    public static void addNonDeadEndAndNonVisitedNeighborsToQueue(List < String > allNeighbors, Set < String > deadendSet, Queue < String > q, Set < String > set) {
        for (String neighbor: allNeighbors) {
            if (!deadendSet.contains(neighbor) && !set.contains(neighbor)) {
                q.add(neighbor);
            }
        }
    }
    public static void addAllNeighborsToVisitedSet(List < String > allNeighbors, Set < String > visited) {
        for (String neighbor: allNeighbors) {
            visited.add(neighbor);
        }
    }
    public static List < String > findAllNeighbors(String numberString) {
        List < String > result = new ArrayList < > ();
        char[] numberArray = numberString.toCharArray();
        for (int i = 0; i < numberArray.length; i++) {

            char number = numberArray[i];
            char upNumber = findUpNumber(number);
            numberArray[i] = upNumber;
            String upString = changeArrayToString(numberArray);
            result.add(upString);
            char downNumber = findDownNumber(number);
            numberArray[i] = downNumber;
            String downString = changeArrayToString(numberArray);
            result.add(downString);
            numberArray[i] = number;

        }
        return result;
    }
    public static String changeArrayToString(char[] numberArray) {
        StringBuilder sb = new StringBuilder();
        for (char c: numberArray) {
            sb.append(c);
        }
        return String.valueOf(sb);
    }
    public static char findUpNumber(char c) {
        if (c == '9') {
            c = '0';
        } else {
            c++;
        }

        return c;
    }
    public static char findDownNumber(char c) {
        if (c == '0') {
            c = '9';

        } else {
            c--;
        }
        return c;
    }
}
