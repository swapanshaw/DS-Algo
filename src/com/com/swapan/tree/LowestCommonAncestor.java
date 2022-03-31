package com.com.swapan.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * . 1650. Lowest Common Ancestor of a Binary Tree III
 */

class Node {
  public int val;
  public Node left;
  public Node right;
  public Node parent;

  public Node(int val) {
    this.val = val;
  }
}

public class LowestCommonAncestor {
  public Node lowestCommonAncestor(Node p, Node q) {
    Set<Node> pNodePath = new HashSet<>();

    Node parent = p;
    while (parent != null) {
      pNodePath.add(p);
      p = parent.parent;
    }

    parent = q;

    while (parent != null) {
      if (pNodePath.contains(parent)) return parent;

      parent = parent.parent;
    }

    return null;
  }
}
