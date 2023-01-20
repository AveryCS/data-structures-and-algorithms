package com.practice.stringproblems;

import java.util.*;
/**Problem statement:
 You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.

 Given the string command, return the Goal Parser's interpretation of command.



 Example 1:

 Input: command = "G()(al)"
 Output: "Goal"
 Explanation: The Goal Parser interprets the command as follows:
 G -> G
 () -> o
 (al) -> al
 The final concatenated result is "Goal".
 Example 2:

 Input: command = "G()()()()(al)"
 Output: "Gooooal"


 Leetcode link: https://leetcode.com/problems/goal-parser-interpretation/description/
 **/

public class GoalParserInterpretation {
    public String interpret(String command) {
        StringBuilder result = new StringBuilder();
        appendToEnd(result, command.toCharArray());
        return String.valueOf(result);
    }

    public static void appendToEnd( StringBuilder result, char [] arr ){
        for( int i = 0; i< arr.length; i++ ){
            if( arr[i]=='G'){
                result.append("G");
            }
            if(arr[i]== ')' && arr[i-1] =='('){
                result.append("o");
            }
            if(arr[i]== 'a'){
                result.append("al");
            }
        }
    }
}
