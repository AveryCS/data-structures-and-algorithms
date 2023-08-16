package com.practice.recursionproblems;
import java.util.*;

/**Problem statement:
 Given the root of a binary tree, return all root-to-leaf paths in any order.

 A leaf is a node with no children.

 Example 1:
 Input: root = [1,2,3,null,5]
 Output: ["1->2->5","1->3"]

 Example 2:
 Input: root = [1]
 Output: ["1"]

 Constraints:
 The number of nodes in the tree is in the range [1, 100].
 -100 <= Node.val <= 100
 -1000 <= targetSum <= 1000

 Leetcode link: https://leetcode.com/problems/binary-tree-paths/description/
 **/
public class BinaryTreePaths {
    public List < String > binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        findPath(result, root, sb);
        return result;

    }
    public static void findPath(List < String > list, TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int end = sb.length();

        if (sb.isEmpty()|| sb.charAt(sb.length()-1) == '>') {
            sb.append(root.val);
        } else {
            sb.append("->");
            sb.append(root.val);
        }
        if (root.left == null && root.right == null) {
            list.add(String.valueOf(sb));
            sb.delete(end, sb.length());
            return;
        }
        findPath(list, root.right, sb);
        findPath(list, root.left, sb);
        sb.delete(end, sb.length());

    }
}
