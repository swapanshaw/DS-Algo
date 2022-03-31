package com.com.swapan.array;

import java.util.Arrays;

public class FirstMissingPositive {

  public static void main(String[] args) {

    int arr[] = {1, 4, 3, 2, 5};
    int length = arr.length;
    for (int i = 0; i < length; i++) {

      if (arr[i] <= 0 || arr[i] > arr.length ) {
        continue;
      }

      swap(arr, i, arr[i] - 1);
    }

    Arrays.stream(arr).forEach(System.out::println);

    for (int i = 1; i < length; i++) {
      if (arr[i - 1] != i) {
        System.out.println(i);
        return;
      }
    }


    System.out.println(arr[length - 1] + 1);
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
