package com.swapan.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmonFordAlgo {

  static class Edge {
    int u;
    int v;
    int w;

    public Edge(int u, int v, int w) {
      this.u = u;
      this.v = v;
      this.w = w;
    }
  }

  static void bellmondford(int src, int n, List<Edge> adj) {
    int dst[] = new int[n];
    Arrays.fill(dst, Integer.MAX_VALUE);

    dst[src] = 0;

    for (int i = 0; i < n - 1; i++) {
      for (Edge edge : adj) {
        int u = edge.u;
        int v = edge.v;
        int w = edge.w;
        if (dst[u] + w < dst[v]) {
          dst[v] = dst[u] + w;
        }
      }
    }

    // relaxing one more time to detect the negative cycle
    for (Edge edge : adj) {
      int u = edge.u;
      int v = edge.v;
      int w = edge.w;
      if (dst[u] + w < dst[v]) {
        System.out.println("Negative Cycle");
        break;
      }
    }

    Arrays.stream(dst).forEach(x -> System.out.println(x));

  }


  public static void main(String[] args) {
    int n = 6;
    List<Edge> adj = new ArrayList<>();
    adj.add(new Edge(3, 2, 6));
    adj.add(new Edge(5, 3, 1));
    adj.add(new Edge(0, 1, 5));
    adj.add(new Edge(1, 5, -3));
    adj.add(new Edge(1, 2, -2));
    adj.add(new Edge(3, 4, -2));
    adj.add(new Edge(2, 4, 3));

    bellmondford(0, n, adj);
  }
}
