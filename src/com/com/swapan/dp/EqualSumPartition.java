package com.com.swapan.dp;

public class EqualSumPartition {

  static boolean equalSumPartition(int arr[]) {
    int n = arr.length;
    int sum = 0;
    for (int num : arr) {
      sum += num;
    }
    //if array len is odd there, can not be divided into equal partion set
    if (sum % 2 != 0) {
      return false;
    }
    // if any subset exusts with sum/2 then there is equal sum partion set
    return canPartion(arr, n, sum / 2);
  }

  static boolean canPartion(int arr[], int n, int sum) {
    if (n == 0) {
      return false;
    }

    if (sum == 0) {
      return true;
    }

    if (arr[n - 1] <= sum) {
      return canPartion(arr, sum - arr[n - 1], n - 1); // inclue this element
    } else {
      //ignore
      return canPartion(arr, sum, n - 1);
    }
  }

  static boolean canPartitionDP(int arr[]) {
    int n = arr.length;
    int sum = 0;
    for (int num : arr) {
      sum += num;
    }

    boolean t[][] = new boolean[n + 1][sum / 2 + 1];

    for (int i = 0; i < n; i++) {
      t[i][0] = true;
    }

    for (int i = 1; i <= sum / 2; i++) {
      t[0][i] = false;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum / 2; j++) {
        if (arr[i - 1] <= j) {
          t[i][j] = t[i - 1][j - arr[i - 1]];
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][sum / 2];
  }

  public static void main(String[] args) {
    int[] num = {1, 2, 3, 4};
    System.out.println(equalSumPartition(num));
    System.out.println(canPartitionDP(num));
    num = new int[]{1, 1, 3, 4, 7};
    System.out.println(equalSumPartition(num));
    System.out.println(canPartitionDP(num));
    num = new int[]{2, 3, 4, 6};
    System.out.println(equalSumPartition(num));
    System.out.println(canPartitionDP(num));
  }
}
