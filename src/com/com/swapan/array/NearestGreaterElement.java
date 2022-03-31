package com.com.swapan.array;

import java.util.Stack;

public class NearestGreaterElement {

  public static void main(String[] args) {
    int[] arr = {4, 2, 1, 5, 6, 3, 2, 4, 2};

    int[] elements = nextSmallerElement(arr);


    for (int i : elements) {
      System.out.println(i);
    }

    System.out.println("--------");
    elements = previousSmallerElement(arr);


    for (int i : elements) {
      System.out.println(i);
    }

    System.out.println("---------: Largest Area -----------");
    System.out.println(largestRectangleHistogram(arr));
  }

  static int[] nearestGreaterElement(int[] arr) {

    if (arr.length == 0) return null;

    Stack<Integer> stack = new Stack<>();
    int len = arr.length;
    int[] nge = new int[len];
    stack.push(arr[len - 1]);
    nge[len - 1] = -1;

    for (int i = len - 2; i >= 0; i--) {

      while (!stack.isEmpty() && stack.peek() <= arr[i]) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        nge[i] = -1;
      } else {
        nge[i] = stack.peek();
      }
      stack.push(arr[i]);

    }

    return nge;
  }

  static int[] nextSmallerElement(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int len = arr.length;
    int[] nse = new int[len];
    nse[len - 1] = len;
    stack.push(len - 1);

    for (int i = len - 2; i >= 0; i--) {
      while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        nse[i] = len;
      } else {
        nse[i] = stack.peek();
      }

      stack.push(i);
    }

    return nse;
  }


  static int[] previousSmallerElement(int arr[]) {
    Stack<Integer> stack = new Stack<>();
    int len = arr.length;
    if (len == 0) return null;
    int pse[] = new int[len];
    stack.push(arr[0]);
    pse[0] = -1;

    for (int i = 1; i < len; i++) {
      while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        pse[i] = -1;
      } else {
        pse[i] = stack.peek();
      }
      stack.push(i);
    }
    return pse;
  }


  static int[] nearestGreaterElementCircular(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int len = arr.length;

    if (len == 0) return null;

    int nge[] = new int[len];
    stack.push(arr[len - 1]);
    nge[len - 1] = -1;

    for (int i = 2 * len - 1; i >= 0; i--) {

      while (!stack.isEmpty() && stack.peek() <= arr[i % len]) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        nge[i % len] = -1;
      } else {
        nge[i % len] = stack.peek();
      }

      stack.push(arr[i % len]);
    }

    return nge;
  }

  static int largestRectangleHistogram(int[] arr) {
    int[] pse = previousSmallerElement(arr);

    int[] nse = nextSmallerElement(arr);
    int maxArea = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      maxArea = Math.max(maxArea, (nse[i] - pse[i] - 1) * arr[i]);
    }

    return maxArea;
  }
}
