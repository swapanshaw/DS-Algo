package com.com.swapan.tree;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/**
 * do  inorder tranversal in case of viaolation in sorting order
 */

public class RecoverBST {

  static private Node first;
  static private Node prev;
  static private Node last;
  static private Node middle;


  static void recoverTree(Node root) {
    first = null;
    last = null;
    middle = null;

    prev = new Node(Integer.MIN_VALUE);

    inorder(root);

    if (first != null && last != null) {
      swap(first, last);
    } else {
      swap(first, middle);
    }
  }

  private static void swap(Node first, Node last) {
    int t = first.val;
    first.val = last.val;
    last.val = t;
  }

  private static void inorder(Node root) {

    if (root == null) return;

    inorder(root.left);

    if (prev != null && prev.val > root.val) {

      if (first == null) {
        first = prev;
        middle = root;
      } else {
        last = root;
      }
    }
    // logic
    prev = root;

    inorder(root.right);
  }
}
