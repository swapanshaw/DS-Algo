package com.com.swapan.tri;


import java.util.ArrayList;
import java.util.List;

public class Tri {
  static int MAX_CHAR = 26;
  static TriNode root;

  public Tri() {
    root = new TriNode();
  }

  static class TriNode {

    TriNode[] children = new TriNode[MAX_CHAR];
    boolean isEnd;
    // use to sort the arr of string in lexographic order
    int index = -1;
  }


  public void insert(String word, int index) {
    if (word.length() == 0) return;
    TriNode node = root;
    for (int i = 0; i < word.length(); i++) {
      int ind = word.charAt(i) - 'a';

      if (node.children[ind] == null) {
        node.children[ind] = new TriNode();
      }
      node = node.children[ind];
    }
    node.isEnd = true;
    node.index = index;
  }

  public boolean search(String word) {
    if (word.length() == 0) return false;
    TriNode node = root;
    for (int i = 0; i < word.length(); i++) {
      int ind = word.charAt(i) - 'a';

      if (node.children[ind] == null) {
        return false;
      }
      node = node.children[ind];
    }
    return node.isEnd;
  }

  public List<String> sortLexoGraphically(String[] str) {
    for (int i = 0; i < str.length; i++) {
      insert(str[i], i);
    }
    List<String> ans = new ArrayList<>();
    preoder(root, str, ans);

    return ans;
  }

  public void preoder(TriNode node, String arr[], List<String> ans) {

    if (node == null) return;

    for (int i = 0; i < MAX_CHAR; i++) {
      if (node.children[i] != null) {
        if (node.children[i].index != -1) {
          ans.add(arr[node.children[i].index]);
        }
        preoder(node.children[i], arr, ans);
      }
    }
  }

  public static void main(String[] args) {

    String arr[] = {"abc", "xy", "bcd"};

    int n = arr.length;

    Tri tri = new Tri();

    System.out.println(tri.sortLexoGraphically(arr));
  }

}
