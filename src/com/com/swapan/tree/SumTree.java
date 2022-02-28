package com.com.swapan.tree;


public class SumTree {

  private int sumTree(BinaryTree.Node root) {
    // leaft sum will be zero
    if (root == null) return 0;

    int leftSum = sumTree(root.left);
    int rightSum = sumTree(root.right);

    int x = root.data;

    root.data = leftSum + rightSum;

    return leftSum + rightSum + x;
  }

  public static void main(String[] args) {

  }
}
