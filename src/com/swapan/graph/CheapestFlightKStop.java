package com.swapan.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlightKStop {

  static int findCheapestFlightKStop(int n, int[][] flights, int src, int dst, int k) {

    Map<Integer, List<int[]>> adj = new HashMap<>();

    for (int fl[] : flights) {
      adj.putIfAbsent(fl[0], new ArrayList<>());
      adj.get(fl[0]).add(new int[]{fl[1], fl[2]});
    }

    // quest contains [price, node, stop]
    Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
    queue.add(new int[]{0, src, k + 1});

    while (!queue.isEmpty()) {
      int[] fl = queue.poll();
      int cost = fl[0];
      int city = fl[1];
      int stop = fl[2];

      if (city == dst) return cost;

      if (stop >= 0) {
        for (int[] nxt : adj.get(city)) {
          queue.add(new int[]{nxt[1] + cost, nxt[0], k - 1});
        }
      }
    }

    return -1;
  }


  public static void main(String[] args) {
    //n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1

    int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {0, 2, 500}
    };

    System.out.println(findCheapestFlightKStop(3, flights, 0, 2, 1));

  }
}
