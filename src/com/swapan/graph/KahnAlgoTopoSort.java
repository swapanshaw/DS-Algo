package com.swapan.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnAlgoTopoSort {

  static class Graph {
    int v;
    List<Integer> adj[];

    public Graph(int v) {
      this.v = v;
      adj = new ArrayList[v];

      for (int i = 0; i < v; i++) {
        adj[i] = new ArrayList<>();
      }
    }

    void addEdge(int u, int w) {
      adj[u].add(w);
    }
  }

  // implement using kahn's algorith
  public static List<Integer> topoLogicalSort(Graph g) {
    // create an inorder list
    int[] inDegree = new int[g.v];

    // populate the inorder list while travesing the vertices and edges
    for (int i = 0; i < g.v; i++) {
      for (int val : g.adj[i]) {
        inDegree[val]++;
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    // push the vertices into queue which has indegree is zero
    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) queue.add(i);
    }
    // traverse over the list in BFS way util the queue become empty
    List<Integer> result = new ArrayList<>();
    int count = 0;
    while (!queue.isEmpty()) {
      int val = queue.poll();
      result.add(val);


      for (int v : g.adj[val]) {
        if (--inDegree[v] == 0) {
          queue.add(v);
        }
      }
      count++;
    }

    if (count != g.v) {
      System.out.println("graph is not DAG");
      return null;
    }

    return result;
  }


  public static void main(String[] args) {
    // Create a graph given in the above diagram
    Graph g = new Graph(6);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);
    System.out.println(
            "Following is a Topological Sort");
    System.out.println(topoLogicalSort(g));
  }
}
