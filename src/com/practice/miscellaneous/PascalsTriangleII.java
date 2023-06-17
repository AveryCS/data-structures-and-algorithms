package com.practice.miscellaneous;
import java.util.*;
/**Problem statement:
 Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

 In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 Example 1:
 Input: rowIndex = 3
 Output: [1,3,3,1]

 Example 2:
 Input: rowIndex = 0
 Output: [1]

 Example 3:
 Input: rowIndex = 1
 Output: [1,1]

 Constraints:
 0 <= rowIndex <= 33
 Leetcode link: https://leetcode.com/problems/pascals-triangle-ii/description/
 **/
public class PascalsTriangleII {
    public List < Integer > getRow(int rowIndex) {
        int prevRowIndex = 0;
        List < Integer > prevList = new ArrayList < > ();
        prevList.add(1);
        if (rowIndex == 0) {
            return prevList;
        }
        int size = prevList.size();
        while (prevRowIndex != rowIndex) {
            //create currentList
            List < Integer > currentList = createCurrentListFromPreviousList(prevList, size);
            size = currentList.size();
            prevList = currentList;
            prevRowIndex++;
        }
        return prevList;
    }
    public static List < Integer > createCurrentListFromPreviousList(List < Integer > prevList, int size) {
        List < Integer > currentList = new ArrayList < > ();
        for (int i = -1, k = i + 1; i < size; i++, k++) {
            int sum = 0;
            if (i == -1) {
                sum += prevList.get(k);
            } else if (k >= prevList.size()) {
                sum += prevList.get(i);
            } else {
                sum += prevList.get(i) + prevList.get(k);
            }
            currentList.add(sum);
        }
        return currentList;
    }
}
