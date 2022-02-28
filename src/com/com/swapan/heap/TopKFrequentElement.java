package com.com.swapan.heap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElement {

  public static void main(String[] args) {
    int[] nums = {1,1,1,2,3,3,5,5,5,5};
    int k = 2;
    Map<Integer, Integer> countMap = new HashMap<>();

    for (int num : nums) {
      countMap.put(num, countMap.getOrDefault(num, 0)+1);
    }

    Queue<Integer> queue = new PriorityQueue<>(k, (n1, n2) -> countMap.get(n1) - countMap.get(n2));

    for (int n : countMap.keySet()) {
      queue.add(n);

      if(queue.size() > k) queue.poll();
    }

    int res[] = new int[k];

    for (int i = k-1; i>=0;i--) {
      //res[i] =

      System.out.println(queue.poll());
    }


  }
}
