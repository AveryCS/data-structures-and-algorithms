package com.practice.miscellaneous;
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
        Set < String > deadendSet = new HashSet < > ();
        for (String s: deadends) {
            deadendSet.add(s);
        }
        if (deadendSet.contains("0000")) {
            return -1;
        }
        Set < String > visitedSet = new HashSet < > ();
        Queue < String > q = new ArrayDeque < > ();
        q.add("0000");
        visitedSet.add("0000");
        int count = 0;
        int size = q.size();
        while (!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; i++) {
                String currentNumber = q.peek();

                if (currentNumber.equals(target)) {
                    return count;
                }
                addNeighborsThatArentDeadends(q, deadendSet, currentNumber, visitedSet);
                q.remove();
            }
            //    for (String s: q) {
            //   System.out.println(s);
            // }

            count++;
        }
        return -1;
    }
    public static void addNeighborsThatArentDeadends(Queue < String > q, Set < String > deadendSet, String number, Set < String > visitedSet) {
        for (String code: getAllNeighbors(number, deadendSet, visitedSet)) {

            if (!deadendSet.contains(code) && !visitedSet.contains(code)) {
                q.add(code);
                visitedSet.add(code);
            }

        }
    }

    public static List < String > getAllNeighbors(String code, Set < String > deadendSet, Set < String > visitedSet) {
        System.out.println("code: "+ code);
        List < String > result = new ArrayList < > ();
        int[] intArray = new int[code.length()];

        for (int i = 0; i < code.length(); i++) {
            intArray[i] = Character.getNumericValue(code.charAt(i));
        }
        for (int i = 0; i < intArray.length; i++) {
            int originalNumber = intArray[i];
            intArray[i] = addNumber(intArray[i]);
            result.add(createAStringNumber(intArray));

            intArray[i] = originalNumber;
            intArray[i] = subtractNumber(originalNumber);
            result.add(createAStringNumber(intArray));

            intArray[i] = originalNumber;
        }

        return result;

    }
    public static String createAStringNumber( int [] intArray){
        StringBuilder sb = new StringBuilder();
        for(int i: intArray){
            sb.append(i);
        }
        return String.valueOf(sb);
    }
    public static int addNumber(int singleNumber) {
        if (singleNumber == 9) {
            return 0;
        } else {
            return singleNumber + 1;
        }
    }

    public static int subtractNumber(int singleNumber) {
        if (singleNumber == 0) {
            return 9;
        } else {
            return singleNumber - 1;
        }
    }
}
