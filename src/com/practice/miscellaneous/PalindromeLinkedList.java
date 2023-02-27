package com.practice.miscellaneous;
import java.util.*;
/**Problem statement:
 Given the head of a singly linked list, return true if it is a
 palindrome
 or false otherwise.

 Example 1:
 Input: head = [1,2,2,1]
 Output: true

 Constraints:
 The number of nodes in the list is in the range [1, 105].
 0 <= Node.val <= 9

 Leetcode link: https://leetcode.com/problems/palindrome-linked-list/description/
 **/
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ArrayDeque <ListNode> q = new ArrayDeque<>();
        while(head != null){
            q.add(head);
            head =head.next;
        }
        while(!q.isEmpty() && q.size()>1){
            if(q.remove().val != q.removeLast().val){
                return false;
            }
        }
        return true;
    }
}
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
