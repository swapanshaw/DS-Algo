package com.com.swapan.tree;

public class BinarySearchTree {

  static class Node {
    int data;
    Node left, right;

    Node(int data) {
      data = data;
      left = right = null;
    }
  }

  static boolean isValidBST(Node node, int minVal, int maxVal) {
    if (node == null) return true;

    if (node.data < minVal && node.data > maxVal) return false;

    return isValidBST(node.left, minVal, node.data) && isValidBST(node.right, node.data, maxVal);
  }

  static Node lca(Node node, int p, int q) {

    if (node == null) return null;

    if (node.data > p && node.data > q) {
      return lca(node.left, p, q);
    }

    if (node.data < p && node.data < q) {
      return lca(node.right, p, q);
    }

    return node;


  }

  public static void main(String[] args) {
    Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(5);
    root.left.left = new Node(1);
    root.left.right = new Node(3);

    if (isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
      System.out.println("IS BST");
    else
      System.out.println("Not a BST");
  }
}
