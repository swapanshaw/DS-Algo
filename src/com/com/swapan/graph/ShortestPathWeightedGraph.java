package com.com.swapan.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Node implements Comparator<Node> {
  public int v;
  public int w;

  public Node() {
  }

  public Node(int v, int w) {
    this.v = v;
    this.w = w;
  }


  @Override
  public int compare(Node o1, Node o2) {
    return o1.w - o2.w;
  }
}

public class ShortestPathWeightedGraph {
  //Dijkstra’s shortest path algorithm
  static int[] shortestPath(List<Node>[] adj, int src) {
    int n = adj.length;
    int[] dist = new int[n];

    Arrays.fill(dist, Integer.MAX_VALUE);
    Queue<Node> pQueue = new PriorityQueue<Node>(n, new Node());

    dist[src] = 0;
    pQueue.add(new Node(src, 0));

    while (!pQueue.isEmpty()) {
      Node curr = pQueue.poll();

      for (Node node : adj[curr.v]) {
        if(dist[curr.v] + node.w < dist[node.v]) {
          dist[node.v] =  dist[curr.v] + node.w;
          pQueue.add(new Node(node.v, dist[node.v]));
        }
      }
    }
    for (int a : dist) {
      System.out.println(a);
    }
    return null;
  }


  public static void main(String[] args) {
    int V = 9;
    List<Node>[] graph
            = new ArrayList[V];
    for (int i = 0; i < V; i++) {
      graph[i] = new ArrayList<>();
    }
    int source = 0;
    graph[0].add(new Node(1, 4));
    graph[0].add(new Node(7, 8));
    graph[1].add(new Node(2, 8));
    graph[1].add(new Node(7, 11));
    graph[1].add(new Node(0, 7));
    graph[2].add(new Node(1, 8));
    graph[2].add(new Node(3, 7));
    graph[2].add(new Node(8, 2));
    graph[2].add(new Node(5, 4));
    graph[3].add(new Node(2, 7));
    graph[3].add(new Node(4, 9));
    graph[3].add(new Node(5, 14));
    graph[4].add(new Node(3, 9));
    graph[4].add(new Node(5, 10));
    graph[5].add(new Node(4, 10));
    graph[5].add(new Node(6, 2));
    graph[6].add(new Node(5, 2));
    graph[6].add(new Node(7, 1));
    graph[6].add(new Node(8, 6));
    graph[7].add(new Node(0, 8));
    graph[7].add(new Node(1, 11));
    graph[7].add(new Node(6, 1));
    graph[7].add(new Node(8, 7));
    graph[8].add(new Node(2, 2));
    graph[8].add(new Node(6, 6));
    graph[8].add(new Node(7, 1));

    shortestPath(graph, 0);
  }
}
