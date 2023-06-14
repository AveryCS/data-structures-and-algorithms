package com.practice.recursionproblems;
import java.util.*;
/**Problem statement:
 You are given the root of a binary tree and an integer k. Besides the left and right children, every node of this tree has two other properties, a string node.val containing only lowercase English letters (possibly empty) and a non-negative integer node.len. There are two types of nodes in this tree:

 Leaf: These nodes have no children, node.len = 0, and node.val is some non-empty string.
 Internal: These nodes have at least one child (also at most two children), node.len > 0, and node.val is an empty string.
 The tree described above is called a Rope binary tree. Now we define S[node] recursively as follows:

 If node is some leaf node, S[node] = node.val,
 Otherwise if node is some internal node, S[node] = concat(S[node.left], S[node.right]) and S[node].length = node.len.
 Return k-th character of the string S[root].

 Note: If s and p are two strings, concat(s, p) is a string obtained by concatenating p to s. For example, concat("ab", "zz") = "abzz".
 Example 1:
 Input: root = [10,4,"abcpoe","g","rta"], k = 6
 Output: "b"
 Explanation: In the picture below, we put an integer on internal nodes that represents node.len, and a string on leaf nodes that represents node.val.
 You can see that S[root] = concat(concat("g", "rta"), "abcpoe") = "grtaabcpoe". So S[root][5], which represents 6th character of it, is equal to "b".

 Example 3:
 Input: root = ["ropetree"], k = 8
 Output: "e"
 Explanation: In the picture below, we put an integer on internal nodes that represents node.len, and a string on leaf nodes that represents node.val.
 You can see that S[root] = "ropetree". So S[root][7], which represents 8th character of it, is equal to "e".

 Constraints:
 The number of nodes in the tree is in the range [1, 103]
 node.val contains only lowercase English letters
 0 <= node.val.length <= 50
 0 <= node.len <= 104
 for leaf nodes, node.len = 0 and node.val is non-empty
 for internal nodes, node.len > 0 and node.val is empty
 1 <= k <= S[root].length

 Leetcode link: https://leetcode.com/problems/extract-kth-character-from-the-rope-tree/description/
 **/
public class ExtractKthCharacterFromTheRopeTree {
    public char getKthCharacter(RopeTreeNode root, int k) {
        StringBuilder sb = new StringBuilder();
        createSB(root, sb);
        return sb.toString().charAt(k - 1);
    }
    public static void createSB(RopeTreeNode root, StringBuilder result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.append(root.val);
        }
        createSB(root.left, result);
        createSB(root.right, result);
    }
}
