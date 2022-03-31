package com.com.swapan.maths;

public class Sqrt {

  static int mySqrt(int x) {
    if (x < 2) return x;

    int left = 2;
    int right = x / 2;

    while (left <= right) {
      int pivot = left + (right - left) / 2;

      int num = pivot * pivot;

      if (num < x) left = pivot + 1;
      else if (num < x) right = pivot - 1;
      else
        return pivot;
    }
    return right;
  }

  public static void main(String[] args) {
    System.out.println(mySqrt(16));
  }
}
