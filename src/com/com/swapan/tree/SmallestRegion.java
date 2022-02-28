package com.com.swapan.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SmallestRegion {

  public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {

    Map<String, String> parentRef = new HashMap<>();

    for (List<String> region : regions) {
      for (int i = 1; i < region.size(); i++) {
        parentRef.put(region.get(i), region.get(0));
      }
    }

    Stack<String> parent1 = new Stack<>();

    String p = region1;

    while (p != null) {
      parent1.add(p);
      p = parentRef.get(p);
    }

    Stack<String> parent2 = new Stack<>();

    p = region2;

    while (p != null) {
      parent2.add(p);
      p = parentRef.get(p);
    }

    String ans = "";

    while (parent1.size() != 0 && parent2.size() != 0) {
      if (parent1.peek().equals(parent2.peek())) {
        ans = parent1.pop();
        parent2.pop();
      } else {
        break;
      }
    }

    return ans;
  }
}
