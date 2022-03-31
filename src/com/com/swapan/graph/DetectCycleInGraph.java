package com.com.swapan.graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInGraph {

  static class Graph {
    int v;
    List<Integer> adj[];

    public Graph(int v) {
      this.v = v;
      this.adj = new ArrayList[v];

      for (int i = 0; i < v; i++) {
        this.adj[i] = new ArrayList<>();
      }
    }

    void addEdge(int u, int v) {
      this.adj[u].add(v);
    }
  }


  static boolean detectCycle(Graph g) {
    boolean visited[] = new boolean[g.v];
    boolean recStack[] = new boolean[g.v];

    for (int i = 0; i < g.v; i++) {
      if (!visited[i] && detectCycleUtil(g, i, recStack, visited)) {
        return true;
      }
    }
    return false;
  }

  static boolean detectCycleUtil(Graph g, Integer node, boolean[] recStack, boolean[] visited) {

    if (recStack[node]) {
      return true;
    }

    if (visited[node]) {
      return false;
    }

    visited[node] = true;
    recStack[node] = true;
    for (int i : g.adj[node]) {
      if (detectCycleUtil(g, i, recStack, visited))
        return true;
    }

    recStack[node] = false;
    return false;
  }


  public static void main(String[] args)
  {
    Graph graph = new Graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);

    if(detectCycle(graph))
      System.out.println("Graph contains cycle");
    else
      System.out.println("Graph doesn't "
              + "contain cycle");
  }

}
