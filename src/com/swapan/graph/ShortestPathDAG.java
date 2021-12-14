package com.swapan.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAG {

  static int[] shortedPath(List<Node> adj[], int src) {
    Stack<Integer> stack = new Stack<>();
    int n = adj.length;


    topologicalSort(adj, stack);

    int dist[] = new int[adj.length];
    Arrays.fill(dist, Integer.MAX_VALUE);

    dist[src] = 0;

    while (!stack.isEmpty()) {
      int i = stack.pop();

      if(dist[i] != Integer.MAX_VALUE) {
        for (Node node : adj[i]) {
          if (dist[i] + node.w < dist[node.v]) {
            dist[node.v] = dist[i] + node.w;
          }
        }
      }
    }

    for (int i : dist) {
      System.out.println(i);
    }
    return null;
  }

  private static void topologicalSort(List<Node>[] adj, Stack<Integer> stack) {
    boolean visited[] = new boolean[adj.length];
    for (int i = 0; i < adj.length; i++) {
      if (!visited[i]) {
        topologicalSortUtil(adj, i, stack, visited);
      }
    }

    System.out.println(stack);
  }

  private static void topologicalSortUtil(List<Node>[] adj, int i, Stack<Integer> stack, boolean[] visited) {
    visited[i] = true;

    for (Node node : adj[i]) {
      if (!visited[node.v]) {
        topologicalSortUtil(adj, node.v, stack, visited);
      }
    }
    stack.push(i);
  }


  public static void main(String[] args) {
    List<Node> adj[] = new List[6];
    for (int i = 0; i < 6; i++) {
      adj[i] = new ArrayList<>();
    }
    adj[0].add(new Node(1, 5));
    adj[0].add(new Node(2, 3));

    adj[1].add(new Node(3, 6));
    adj[1].add(new Node(2, 2));
    adj[2].add(new Node(4, 4));
    adj[2].add(new Node(5, 2));
    adj[2].add(new Node(3, 7));
    adj[3].add(new Node(4, -1));
    adj[4].add(new Node(5, -2));


    shortedPath(adj, 1);
  }
}
