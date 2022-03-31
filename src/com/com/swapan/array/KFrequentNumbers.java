package com.com.swapan.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class KFrequentNumbers {

  public static void main(String[] args) {
    int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
    int n = arr.length;
    int k = 2;
    findTopKMostOcuranceNumbers(arr, k);
  }

  static List<Integer> findTopKMostOcuranceNumbers(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
            (a, b) -> a.getValue().equals(b.getValue()) ?
                    a.getKey().compareTo(b.getKey()) :
                    a.getValue().compareTo(b.getValue()));

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      queue.offer(entry);
      if (queue.size() > k)
        queue.poll();
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i <= queue.size(); i++) {
      System.out.println(queue.peek().getKey() + ":" + queue.peek().getValue());
      list.add(queue.peek().getValue());
      queue.poll();
    }

    return list;
  }
}
