package com.com.swapan.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {

  public static void main(String[] args) {

    Graph g = new Graph(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println("Following is Breadth First Traversal " +
            "(starting from vertex 2)");

    g.bfs(2);

    // Total 5 vertices in graph
    /*Graph g = new Graph(5);

    g.addEdge(1, 0);
    g.addEdge(0, 2);
    g.addEdge(2, 1);
    g.addEdge(0, 3);
    g.addEdge(1, 4);

    System.out.println("Following is the Depth First Traversal");
    g.dfs(0);*/


  }

  static class Graph {
    LinkedList<Integer> adj[];

    public Graph(int v) {
      adj = new LinkedList[v];
      for (int i = 0; i < v; i++) {
        adj[i] = new LinkedList<>();
      }
    }

    void addEdge(int s, int d) {
      adj[s].add(d);
      adj[d].add(s);
    }

    public void dfs(int s) {
      Stack<Integer> stack = new Stack<>();
      boolean[] vis = new boolean[adj.length];
      stack.push(s);
      vis[s] = true;
      while (!stack.isEmpty()) {
        Integer curr = stack.pop();
        System.out.println(curr);

        for (int i : adj[curr]) {
          if (!vis[i]) {
            vis[i] = true;
            //System.out.println(curr);
            stack.push(i);
          }
        }
      }
    }

    public void bfs(int s) {
      boolean vis[] = new boolean[adj.length];
      Queue<Integer> queue = new LinkedList<>();

      queue.add(s);
      vis[s] = true;

      while (!queue.isEmpty()) {
        int curr = queue.poll();
        System.out.println(curr);

        for (int i : adj[curr]) {
          if (!vis[i]) {
            vis[i] = true;
            queue.add(i);
          }
        }
      }
    }
  }
}
