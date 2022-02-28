package com.com.swapan.sorting;

import java.util.Arrays;

public class FindMinPlatform {

  static int findPlatform(int arr[], int dep[], int n) {

    Arrays.sort(arr);
    Arrays.sort(dep);

    int i = 1;
    int j = 0;
    int pNeeded = 1;
    int res = 1;

    while (i < n && j < n) {

      if (arr[i] <= dep[j]) {
        pNeeded++;
        i++;
      } else {
        pNeeded--;
        j++;
      }

      res = Math.max(res, pNeeded);
    }

    return res;
  }

  public static void main(String[] args) {
    int arr[] = {900, 940, 950, 1100, 1500, 1800};
    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
    int n = arr.length;
    System.out.println("Minimum Number of Platforms Required = "
            + findPlatform(arr, dep, n));
  }
}
