package com.practice.stringproblems;
import java.util.*;
/**Problem statement:
 A cell (r, c) of an excel sheet is represented as a string "<col><row>" where:

 <col> denotes the column number c of the cell. It is represented by alphabetical letters.
 For example, the 1st column is denoted by 'A', the 2nd by 'B', the 3rd by 'C', and so on.
 <row> is the row number r of the cell. The rth row is represented by the integer r.
 You are given a string s in the format "<col1><row1>:<col2><row2>", where <col1> represents the column c1, <row1>
 represents the row r1, <col2> represents the column c2, and <row2> represents the row r2, such that r1 <= r2 and c1
 <= c2.

 Return the list of cells (x, y) such that r1 <= x <= r2 and c1 <= y <= c2. The cells should be represented as
 strings in the format mentioned above and be sorted in non-decreasing order first by columns and then by rows.

 Input: s = "K1:L2"
 Output: ["K1","K2","L1","L2"]
 Explanation:
 The above diagram shows the cells which should be present in the list.
 The red arrows denote the order in which the cells should be presented.

 Leetcode link: https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/description/
 **/
public class CellsInARangeOnAnExcelSheet {
    public List < String > cellsInRange(String s) {
        String[] arr = s.split(":");
        List < String > result = new ArrayList < > ();
        List < Character > charList = createCharacterList(arr[0].charAt(0), arr[1].charAt(0));
        List < Integer > numberList = createNumberList(Character.getNumericValue(arr[0].charAt(1)), Character.getNumericValue(arr[1].charAt(1)));

        for (Character c: charList) {
            for (Integer i: numberList) {
                StringBuilder temp = new StringBuilder();
                result.add(String.valueOf(temp.append(c).append(i)));
            }
        }
        return result;
    }
    public static List < Character > createCharacterList(char a, char b) {
        List < Character > list = new ArrayList < > ();

        for (char i = a; i <= b; i++) {
            list.add(i);
        }
        return list;
    }

    public static List < Integer > createNumberList(Integer a, Integer b) {
        List < Integer > numberList = new ArrayList < > ();

        for (int i = a; i <= b; i++) {
            numberList.add(i);
        }

        return numberList;

    }
}
