package com.swapanb.ds.dp;

public class SubsetSumProblem {

  public static void main(String[] args) {
    int set[] = {3, 34, 4, 12, 5, 2};
    int sum = 9;
    int n = set.length;
    if (isSubsetSumDP(set, n, sum) == true)
      System.out.println("Found a subset"
              + " with given sum");
    else
      System.out.println("No subset with"
              + " given sum");
  }

  static boolean isSubsetSum(int arr[], int n, int sum) {

    if (sum == 0) {
      return true;
    }

    if (n == 0) {
      return false;
    }

    if (arr[n - 1] <= sum) {
      // include it or exclude it
      return isSubsetSum(arr, n - 1, sum - arr[n - 1]) || isSubsetSum(arr, n - 1, sum);
    } else {
      return isSubsetSum(arr, n - 1, sum);
    }
  }

  static boolean isSubsetSumDP(int arr[], int n, int sum) {

    boolean t[][] = new boolean[arr.length + 1][sum + 1];
    //fill the all t[r][0]
    for (int i = 0; i <= arr.length; i++) {
      t[i][0] = true;
    }

    for (int i = 1; i <= sum; i++) {
      t[0][i] = false;
    }
    for (int i = 1; i <= arr.length; i++) {
      for (int j = 1; j <= sum; j++) {
        if (arr[i - 1] <= j) {
          t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
        } else {
          t[i][j] = t[i - 1][j];
        }
      }
    }
    return t[n][sum];
  }
}
