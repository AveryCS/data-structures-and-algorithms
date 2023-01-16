package com.practice.stringproblems;
import java.io.*;
import java.util.*;


/**Problem statement:
Given a String, return a String with the first letter of each word in uppercase, unless the String has two letters
 or less. If a Stirng has two letters or less, the entire String should be lowercase.
 Example: CAStLe is the OwnEr should return  Castle is The Owner**/
public class CorrectStringUppercase {
    static public void main( String args[] ) {
        String str = "CAStLe is the OwnEr ";
        System.out.print(correctString(str));
    }
    public static String correctString( String s){
        String [] parts = s.split(" ");
        StringBuilder result = new StringBuilder ();
        for(String k: parts){
            String word = "";
            if(k.length() > 2){
                word = k.substring(0,1).toUpperCase() + k.substring(1).toLowerCase();
            }else{
                word = k.toLowerCase();
            }
            result.append(word + " ");
        }
        return result.toString().trim();
    }
}
