package com.com.swapan.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduling {

  public static boolean canFinish(int numCourses, int[][] prerequisites) {

    Map<Integer, List<Integer>> adj = new HashMap<>();
    //List<Integer> adj[] = new List[numCourses];

    for (int i = 0; i < numCourses; i++) {
      adj.put(i, new ArrayList<>());
      //adj[i] = new ArrayList<>();
    }

    for (int[] preq : prerequisites) {
      adj.get(preq[1]).add(preq[0]);
    }
    boolean visited[] = new boolean[numCourses];
    boolean callStack[] = new boolean[numCourses];

    for (int i = 0; i < numCourses; i++) {
      if (!visited[i] && isCycle(i, adj, callStack, visited))
        return false;

    }

    return true;
  }

  private static boolean isCycle(int v, Map<Integer, List<Integer>> adj, boolean[] stack, boolean[] visited) {

    if (stack[v]) return true;

    if (visited[v]) return false;

    visited[v] = true;
    stack[v] = true;

    for (int curr : adj.get(v)) {
      if (isCycle(curr, adj, stack, visited))
        return true;
    }

    stack[v] = false;

    return false;
  }


  public static void main(String[] args) {
    int numTasks = 2;

    int[][] prerequisites = new int[][]{
            {1, 0},
            {0, 1}
    };

    if (canFinish(numTasks, prerequisites)) {
      System.out.println("Possible to finish all tasks");
    } else {
      System.out.println("Impossible to finish all tasks");
    }
  }
}
