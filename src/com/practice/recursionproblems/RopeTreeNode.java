package com.practice.recursionproblems;

public class RopeTreeNode {
      int len;
      String val;
      RopeTreeNode left;
      RopeTreeNode right;
      RopeTreeNode() {}
      RopeTreeNode(String val) {
          this.len = 0;
          this.val = val;
      }
      RopeTreeNode(int len) {
          this.len = len;
          this.val = "";
      }
      RopeTreeNode(int len, RopeTreeNode left, RopeTreeNode right) {
          this.len = len;
          this.val = "";
          this.left = left;
          this.right = right;
      }
  }
