package com.swapan.array;

import java.util.HashSet;
import java.util.Set;

public class ThreeSum {

  public static void main(String[] args) {
    int a[] = {1, 4, 45, 6, 10, 8};
    //threeSum(a, 22);
    //System.out.println(reverse(1534236469));
    System.out.println(convert("-123"));

    //System.out.println(Integer.valueOf("-123"));
  }

  static void threeSum(int[] arr, int sum) {

    int len = arr.length;

    for (int i = 0; i < len; i++) {
      int curr_sum = sum - arr[i];
      Set<Integer> set = new HashSet<>();

      for (int j = i + 1; j < len; j++) {
        int diff = curr_sum - arr[j];
        if (set.contains(diff)) {
          System.out.println(arr[i] + " " + arr[j] + " " + diff);

        }
        set.add(arr[j]);
      }
    }
  }


  static int reverse(int x) {
    if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
      return 0;

    int res = 0;
    while (x != 0) {
      int digit = x % 10;
      x = x / 10;

      if (res > Integer.MAX_VALUE / 10) return 0;
      if (res < Integer.MIN_VALUE / 10) return 0;

      res = res * 10 + digit;
    }

    return res;
  }


  static int convert(String s) {
    if (s.length() == 0) return 0;
    int res = 0;
    boolean isNegative = false;
    for (Character c : s.toCharArray()) {
      if (c == '-') {
        isNegative = true;
        continue;
      }
      int d = Integer.valueOf(c.toString(), 10);

      if (res > Integer.MAX_VALUE / 10) return 0;
      if (res < Integer.MIN_VALUE / 10) return 0;
      res = res * 10 + d;
    }

    return isNegative ? -res : res;
  }
}
