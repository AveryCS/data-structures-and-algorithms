package com.practice.recursionproblems;
import java.util.ArrayList;
import java.util.List;

/**Problem statement:
 Given a String, create a method that reverse the String recursively  **/
public class ReverseStringRecursively {
    static public void main( String args[] ) {
        String result = reverseString("Avery", 4);

        System.out.print(result);
    }
//Solution 1 - using .substring
    public static String reverseString( String s){
        String result = "";
        if(s.length() <= 0){
            return result;
        }

        result = s.substring(s.length()-1) + reverseString(s.substring(0,s.length()-1) );

        return result;
    }
//Solution 2 - passing in an index
public static String reverseString(String s, int index){
    String result ="";
    if( index <0){
        return result;
    }
    result = s.charAt(index)+ reverseString(s, index-1);
    return result;

}

}
