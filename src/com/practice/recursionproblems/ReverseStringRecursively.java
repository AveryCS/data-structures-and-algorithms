package com.practice.recursionproblems;
import java.util.ArrayList;
import java.util.List;

/**Problem statement:
 Given a String, create a method that reverse the String recursively  **/
public class ReverseStringRecursively {
    static public void main( String args[] ) {
        String result = reverseString("Avery");

        System.out.print(result);
    }

    public static String reverseString( String s){
        String result = "";
        if(s.length() <= 0){
            return result;
        }

        result = s.substring(s.length()-1) + reverseString(s.substring(0,s.length()-1) );

        return result;
    }
}
