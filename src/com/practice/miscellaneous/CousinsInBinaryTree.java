package com.practice.miscellaneous;
import java.util.*;

/**Problem statement:
 Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

 Two nodes of a binary tree are cousins if they have the same depth with different parents.

 Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

 Example 1:
 Input: root = [1,2,3,4], x = 4, y = 3
 Output: false

 Example 2:
 Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 Output: true

 Example 3:
 Input: root = [1,2,3,null,4], x = 2, y = 3
 Output: false

 Constraints:
 The number of nodes in the tree is in the range [2, 100].
 1 <= Node.val <= 100
 Each node has a unique value.
 x != y
 x and y are exist in the tree.

 Leetcode link: https://leetcode.com/problems/cousins-in-binary-tree/
 **/

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Set < NodeObject > objectSet = new HashSet < > ();
        return areCousins(root, x, y, objectSet);

    }
    public static boolean areCousins(TreeNode root, int x, int y, Set < NodeObject > objectSet) {
        if (root == null) {
            return false;
        }

        Queue < TreeNode > q = new ArrayDeque < > ();
        q.add(root);
        int size = q.size();
        int count = 0;

        while (!q.isEmpty()) {
            //invariant: there will be one full level in the queue
            size = q.size();
            Set < Integer > set = new HashSet < > ();
            //we have an empty objectSet
            //invariant: if it is the root node, the objectSet will have the root
            for (TreeNode node: q) {
                set.add(node.val);
            }

            //invariant: there is a set with one full level of Integers in it
            //

            if (set.contains(x) || set.contains(y)) {
                return set.contains(x) && set.contains(y) && !sharesParents(objectSet, x, y);
            }
            //invariant: all items from the previous level will be removed
            objectSet.clear();
            for (int i = 0; i < size; i++) {

                TreeNode current = q.peek();
                //add neighbors
                if (current.left != null) {
                    q.add(current.left);
                    objectSet.add(new NodeObject(current.left, current));
                }
                if (current.right != null) {
                    q.add(current.right);
                    objectSet.add(new NodeObject(current.right, current));
                }
                q.remove();
            }
            count++;
            //invariant: all neighbors from previous level have been removed from the queue and a full next level has been added

            //there will be a full level in the objectSet

        }
        return false;
    }
    public static boolean sharesParents(Set < NodeObject > objectSet, int x, int y) {
        TreeNode xParent = new TreeNode();
        TreeNode yParent = new TreeNode();

        for (NodeObject nodeObj: objectSet) {
            if (nodeObj.node.val == x) {
                xParent = nodeObj.parent;
            }
            if (nodeObj.node.val == y) {
                yParent = nodeObj.parent;
            }
        }

        return xParent == yParent;

    }
}

class NodeObject {
    TreeNode node;
    TreeNode parent;

    NodeObject(TreeNode node, TreeNode parent) {
        this.node = node;
        this.parent = parent;

    }

    NodeObject(TreeNode node) {
        this.node = node;
        this.parent = null;
    }
}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
