package com.swapan.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduling2 {
  // using kahn algorithm with topological sort
  public int[] findOrder(int numCourses, int[][] prerequisites) {

    // create adjacencyList
    Map<Integer, List<Integer>> adj = new HashMap<>();
    populateAdjList(adj, numCourses, prerequisites);

    // populate inDegree array with incoming edge count
    int[] inDegree = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      for (int node : adj.get(i)) {
        inDegree[node]++;
      }
    }

    // using BFS approach for topologicalSort
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) queue.add(i);
    }

    int[] result = new int[numCourses];
    int idx = 0;
    while (!queue.isEmpty()) {
      int curr = queue.poll();
      result[idx++] = curr;
      // visit adj node
      for (int node : adj.get(curr)) {
        if (--inDegree[node] == 0)
          queue.add(node);
      }
    }

    if (idx != adj.size()) {
      return new int[0];
    }

    return result;

  }

  private void populateAdjList(Map<Integer, List<Integer>> adj, int n, int[][] prerequisites) {

    for (int i = 0; i < n; i++) {
      adj.put(i, new ArrayList<>());
    }

    for (int[] preq : prerequisites) {
      adj.get(preq[1]).add(preq[0]);
    }

  }

  public static void main(String[] args) {
    int[][] input = new int[][]{
            {1, 0}, {0, 1}
    };
    CourseScheduling2 obj = new CourseScheduling2();
    int[] order = obj.findOrder(2, input);

    Arrays.stream(order).forEach(i -> System.out.println(i));

  }
}
