package com.com.swapan.array;

import java.util.PriorityQueue;
import java.util.Queue;

public class kthLargestAndSmallestElement {

  public static void main(String[] args) {
    int arr[] = {7, 10, 4, 3, 20, 15};

    System.out.println(kThLargestElement(arr, 4));
  }


  private static int kThSmallestElement(int arr[], int k) {
    int len = arr.length;

    if (len == 0) return -1;

    Queue<Integer> pQueue = new PriorityQueue<>((x1,x2) -> x2.compareTo(x1));

    for (int i : arr) {
      pQueue.add(i);
      if (pQueue.size() > k) {
        pQueue.poll();
      }
    }
    return pQueue.peek();
  }


  private static int kThLargestElement(int arr[], int k) {
    int len = arr.length;

    if (len == 0) return -1;

    Queue<Integer> pQueue = new PriorityQueue<>(); // min heap

    for (int i : arr) {
      pQueue.add(i);
      if (pQueue.size() > k) {
        pQueue.poll();
      }
    }
    return pQueue.peek();
  }
}
