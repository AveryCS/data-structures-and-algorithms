package com.practice.miscellaneous;
import java.util.*;
/**Problem statement:
 Given an integer numRows, return the first numRows of Pascal's triangle.

 In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 Example 1:

 Input: numRows = 5
 Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 Example 2:

 Input: numRows = 1
 Output: [[1]]

 Leetcode link: https://leetcode.com/problems/pascals-triangle/description/
 **/
public class PascalsTriangle {
    public List < List < Integer >> generate(int numRows) {
        List < List < Integer >> result = new ArrayList < > ();
        result.add(List.of(1));
        int prevRow = 0;

        while (numRows > 1) {
            List < Integer > currentList = new ArrayList < > ();
            List < Integer > previousList = result.get(prevRow);
            for (int i = -1, k = i + 1; i < previousList.size(); i++, k++) {
                int sum = 0;
                if (isOutOfBounds(i, previousList)) {
                    sum += previousList.get(k);;
                } else if (isOutOfBounds(k, previousList)) {
                    sum += previousList.get(i);
                } else {
                    sum += previousList.get(k) + previousList.get(i);
                }
                currentList.add(sum);
            }
            result.add(currentList);
            numRows--;
            prevRow++;
        }
        return result;
    }
    public static boolean isOutOfBounds(int i, List < Integer > previousList) {
        return i == -1 || i >= previousList.size();
    }
}
