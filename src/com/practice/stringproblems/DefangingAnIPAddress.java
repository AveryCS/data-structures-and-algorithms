package com.practice.stringproblems;
/**Problem statement:
 Given a valid (IPv4) IP address, return a defanged version of that IP address.

 A defanged IP address replaces every period "." with "[.]".

 Example 1:

 Input: address = "1.1.1.1"
 Output: "1[.]1[.]1[.]1"

 Leetcode link: https://leetcode.com/problems/defanging-an-ip-address/description/
 **/

public class DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        char [] arr = address.toCharArray();


        StringBuilder result = new StringBuilder();
        for(char s : arr){
            if( s != '.'){
                result.append(s);
            }else{
                result.append("[.]");
            }
        }

        return String.valueOf(result);

    }

    }
}
