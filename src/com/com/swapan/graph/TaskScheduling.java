package com.com.swapan.graph;

import java.util.ArrayList;
import java.util.List;

class TaskMeta {
  private String name;

  public TaskMeta(String name) {
    this.name = name;
  }
}
public class TaskScheduling {

  static void scheduleTask(List<String> tasks) {
    List<TaskMeta> adj[] = new List[tasks.size()];

    for (int i = 0; i < tasks.size(); i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < tasks.size(); i++) {
      adj[i] = new ArrayList<>();
    }
  }
}
