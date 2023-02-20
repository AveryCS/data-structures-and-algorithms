package com.practice.slidingwindowproblems;
/**Problem statement:
 The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string
 that meet the following conditions:
 It has a length of k.
 It is a divisor of num.
 Given integers num and k, return the k-beauty of num.

 Note:
 Leading zeros are allowed.
 0 is not a divisor of any value.
 A substring is a contiguous sequence of characters in a string.

 Example 1:
 Input: num = 240, k = 2
 Output: 2
 Explanation: The following are the substrings of num of length k:
 - "24" from "240": 24 is a divisor of 240.
 - "40" from "240": 40 is a divisor of 240.
 Therefore, the k-beauty is 2.

 Leetcode link: https://leetcode.com/problems/find-the-k-beauty-of-a-number/description/
 **/
public class FindTheKBeautyOfANumber {
    public int divisorSubstrings(int num, int k) {
        int count = 0;
        for (int i = 0; i <= String.valueOf(num).length() - k; i++) {
            int check = returnInteger(i, num, k);
            if (check != 0 && num % check == 0) {
                System.out.println(check);
                count++;
            }
        }
        return count;
    }

    public static int returnInteger(int index, int num, int k) {
        String number = Integer.toString(num);
        StringBuilder result = new StringBuilder();
        int i = index;
        for (int j = 0; j < k; j++) {
            result.append(number.charAt(i));
            i++;
        }
        return Integer.valueOf(result.toString());
    }
}
