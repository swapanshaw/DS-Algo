package com.com.swapan.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTree {

  public static class Node {
    int data;
    Node left;
    Node right;
    int hd;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }

  }


  public static void main(String[] args) {
    Node root = new Node(1);
    /*root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    //inOrder(root);
    //System.out.println(levelOrderTraversal(root));

    System.out.println(bottomView(root));*/


 /*   root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    System.out.println("LCA(4, 5) = " + lca(root, 4, 5).data);
    System.out.println("LCA(4, 6) = " + lca(root, 4, 6).data);
    System.out.println("LCA(3, 4) = " + lca(root, 3, 4).data);
    System.out.println("LCA(2, 4) = " + lca(root, 2, 4).data);

    System.out.println(printPathFromRootToNode(root, 2));*/


    //Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.left.right = new Node(8);
    root.right.right.right = new Node(9);
    System.out.println("Vertical Order traversal is");
    System.out.println(verticalOrderTraversal(root));
  }

  static void inOrder(Node node) {
    if (node == null) return;

    inOrder(node.left);
    System.out.println(node.data);
    inOrder(node.right);
  }


  static List<List<Integer>> levelOrderTraversal(Node node) {
    if (node == null) return null;

    Queue<Node> queue = new LinkedList<>();
    List<List<Integer>> wrappedList = new ArrayList<>();

    queue.offer(node);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> levelList = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        Node currentNode = queue.peek();
        levelList.add(currentNode.data);
        if (currentNode.left != null) queue.offer(currentNode.left);
        if (currentNode.right != null) queue.offer(currentNode.right);
        queue.remove();
      }
      wrappedList.add(levelList);
    }

    return wrappedList;
  }


  static List<Integer> bottomView(Node root) {
    List<Integer> ans = new ArrayList<>();

    Queue<Node> queue = new LinkedList<>();
    Map<Integer, Integer> map = new TreeMap<>();

    queue.offer(root);
    root.hd = 0;
    while (!queue.isEmpty()) {
      Node curr = queue.remove();
      int hd = curr.hd;
      map.put(hd, curr.data);

      if (curr.left != null) {
        curr.left.hd = hd - 1;
        queue.offer(curr.left);
      }

      if (curr.right != null) {
        curr.right.hd = hd + 1;
        queue.offer(curr.right);
      }
    }

    map.values().forEach(x -> ans.add(x));

    return ans;
  }

  static Node lca(Node node, int p, int q) {

    if (node == null) return null;

    if (node.data == p || node.data == q) return node;


    Node left = lca(node.left, p, q);
    Node right = lca(node.right, p, q);

    if (left != null && right != null) {
      return node;
    }

    return left != null ? left : right;
  }

  static Map<Integer, List<Integer>> verticalOrderTraversal(Node root) {

    if (root == null) return null;

    Queue<Tuple> queue = new LinkedList<>();
    Map<Integer, List<Integer>> map = new TreeMap<>();
    queue.offer(new Tuple(root, 0));
    List<Integer> list = null;
    while (!queue.isEmpty()) {
      Tuple tuple = queue.remove();

      list = map.get(tuple.hd) == null ? new ArrayList<>() : map.get(tuple.hd);
      list.add(tuple.node.data);
      map.put(tuple.hd, list);

      if (tuple.node.left != null) {
        queue.offer(new Tuple(tuple.node.left, tuple.hd - 1));
      }

      if (tuple.node.right != null) {
        queue.offer(new Tuple(tuple.node.right, tuple.hd + 1));
      }
    }

    return map;
  }

  static class Tuple {
    Node node;
    int hd;

    public Tuple(Node node, int hd) {
      this.node = node;
      this.hd = hd;
    }
  }


  static List<Integer> printPathFromRootToNode(Node node, int x) {
    if (node == null) return null;

    List<Integer> list = new ArrayList<>();


    while (node != null) {
      list.add(node.data);

      if (node.data == x) break;

      if (node.left != null) {
        node = node.left;
      }

      if (node.right != null) {
        node = node.right;
      }

      list.remove(list.size() - 1);
    }
    return list;
  }
}
