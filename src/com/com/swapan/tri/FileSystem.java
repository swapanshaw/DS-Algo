package com.com.swapan.tri;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {

  class TriNode {
    String name;
    int val;
    Map<String, TriNode> map = new HashMap<>();

    TriNode(String name, int val) {
      this.name = name;
      this.val = val;
    }
  }

  TriNode root;

  public FileSystem() {
    this.root = new TriNode("", -1);
  }

  public boolean createPath(String path, int value) {

    String[] subPath = path.split("/");
    TriNode curr = root;
    for (int i = 1; i < subPath.length; i++) {

      if (!curr.map.containsKey(subPath[i])) {
        if (i == subPath.length - 1) {
          curr.map.put(subPath[i], new TriNode(subPath[i], value));
          return true;
        }
      }
      curr = curr.map.get(subPath[i]);
    }
    return false;
  }

  public int get(String path) {
    String[] subPath = path.split("/");

    TriNode curr = root;
    for (int i = 1; i < subPath.length; i++) {
      if (!curr.map.containsKey(subPath[i])) {
        return -1;
      }
      curr = curr.map.get(subPath[i]);
    }
    return curr.val;
  }


  public static void main(String[] args) {
    FileSystem fileSystem = new FileSystem();

    System.out.println(fileSystem.createPath("/a", 4));

    System.out.println(fileSystem.createPath("/a/b", 8));

    System.out.println(fileSystem.get("/a/b"));
    //fileSystem.get()
  }
}
