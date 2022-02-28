package com.swapan.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BiPartiteGraph {

  static boolean checkBiPartite(Map<Integer, List<Integer>> adj, int node, int[] color) {

    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    color[node] = 0;
    while(!queue.isEmpty()) {
      int curr = queue.poll();

      for (int i : adj.get(curr)) {
        if(color[i] == -1) {
          color[i] = 1 - color[curr];
        }else if(color[i] == color[curr]) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i<3;i++) {
      map.putIfAbsent(i, new ArrayList<>());
      map.get(i).add(2);
    }


  }
}
