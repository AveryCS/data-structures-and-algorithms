package com.practice.recursionproblems;
import java.util.*;
/**Problem statement:
 Given the head of a singly linked list, return true if it is a
 palindrome
 or false otherwise.

 Example 1:
 Input: head = [1,2,2,1]
 Output: true

 Example 2:
 Input: head = [1,2]
 Output: false

 Constraints:
 The number of nodes in the list is in the range [1, 105].
 0 <= Node.val <= 9

 Leetcode link: https://leetcode.com/problems/palindrome-linked-list/description/
 **/
public class PalindromeLinkedListRecursion {
    ListNode node;

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (node == null) {
            node = head;
        }
        boolean isPal = isPalindrome(head.next);
        if (node.val == head.val) {
            node = node.next;
        } else {
            return false;
        }
        return isPal;
    }
}